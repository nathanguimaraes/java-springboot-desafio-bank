package soluciona.dev.bank.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soluciona.dev.bank.controller.dto.CreateWalletDto;
import soluciona.dev.bank.entity.Wallet;
import soluciona.dev.bank.service.WalletService;

import java.util.List;

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

    @GetMapping("/wallets/{cpfCnpj}")
    public ResponseEntity<Wallet> getWalletByCpfCnpj(@PathVariable String cpfCnpj) {
        Wallet wallet = walletService.findByCpfCnpj(cpfCnpj);
        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/wallets")
    public ResponseEntity<List<Wallet>> getAllWallets() {
        List<Wallet> wallets = walletService.findAll();
        return ResponseEntity.ok(wallets);
    }
}