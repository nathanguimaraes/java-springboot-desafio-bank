package soluciona.dev.picpay.controller.dto;


import soluciona.dev.picpay.entity.Wallet;
import soluciona.dev.picpay.entity.WalletType;

public record CreateWalletDto(String fullName,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletType.Enum walletType) {

    public Wallet toWallet(){
        return new Wallet(
            fullName,
                cpfCnpj,
                email,
                password,
                walletType.get()
        );
    }
}
