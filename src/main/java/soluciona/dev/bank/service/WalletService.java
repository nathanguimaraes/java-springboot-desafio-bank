package soluciona.dev.bank.service;

import org.springframework.stereotype.Service;
import soluciona.dev.bank.controller.dto.CreateWalletDto;
import soluciona.dev.bank.entity.Wallet;
import soluciona.dev.bank.exception.WalletDataAlreadyExistsException;
import soluciona.dev.bank.exception.WalletNotFoundException;
import soluciona.dev.bank.repository.WalletRepository;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {
        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email Already exists");
        }
        return walletRepository.save(dto.toWallet());
    }

    public Wallet findByCpfCnpj(String cpfCnpj) {
        return walletRepository.findByCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found with CPF/CNPJ: " + cpfCnpj));
    }


    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }
}