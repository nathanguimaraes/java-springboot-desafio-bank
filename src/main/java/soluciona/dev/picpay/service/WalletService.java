package soluciona.dev.picpay.service;

import org.springframework.stereotype.Service;
import soluciona.dev.picpay.controller.dto.CreateWalletDto;
import soluciona.dev.picpay.entity.Wallet;
import soluciona.dev.picpay.exception.WalletDataAlreadyExistsException;
import soluciona.dev.picpay.repository.WalletRepository;

@Service
public class WalletService {

        private final WalletRepository walletRepository;

        public WalletService (WalletRepository walletRepository){
            this.walletRepository =  walletRepository;
        }

        public Wallet createWallet(CreateWalletDto dto){

            var walletDb =  walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
            if (walletDb.isPresent()){
                throw new WalletDataAlreadyExistsException("CpfCnpj or Email Already exists");

            }

          return walletRepository.save(dto.toWallet());
        }

}
