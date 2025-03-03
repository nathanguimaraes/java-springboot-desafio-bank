package soluciona.dev.picpay.controller;

import feign.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import soluciona.dev.picpay.controller.dto.CreateWalletDto;
import soluciona.dev.picpay.entity.Wallet;
import soluciona.dev.picpay.service.WalletService;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto dto){

        var wallet = walletService.createWallet(dto);

        return ResponseEntity.ok(wallet);

    }
}
