package soluciona.dev.picpay.service;

import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;
import soluciona.dev.picpay.controller.dto.TransferDto;
import soluciona.dev.picpay.entity.Transfer;
import soluciona.dev.picpay.entity.Wallet;
import soluciona.dev.picpay.exception.InsufficientBalanceException;
import soluciona.dev.picpay.exception.TransferNotAuthorizedException;
import soluciona.dev.picpay.exception.WalletNotFoundException;
import soluciona.dev.picpay.repository.TransferRepository;
import soluciona.dev.picpay.repository.WalletRepository;
import soluciona.dev.picpay.exception.TransferNotAllowedForWalletTypeException;

import java.util.concurrent.CompletableFuture;


@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;

    public TransferService(TransferRepository transferRepository,
                           AuthorizationService authorizationService,
                           NotificationService notificationService,
                           WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Transfer transfer(TransferDto transferDto) {

        var sender = walletRepository.findById(transferDto.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payer()));

        var receiver = walletRepository.findById(transferDto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDto.payee()));

        validateTransfer(transferDto, sender);

        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());

        var transfer = new Transfer(sender, receiver, transferDto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult)); //notificacao

        return transferResult;
    }

    private void validateTransfer(TransferDto transferDto, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalancerEqualOrGreatherThan(transferDto.value())) {
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized(transferDto)) {
            throw new TransferNotAuthorizedException();
        }

    }
}
