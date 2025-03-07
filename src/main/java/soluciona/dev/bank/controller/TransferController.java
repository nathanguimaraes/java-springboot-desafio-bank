package soluciona.dev.bank.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soluciona.dev.bank.controller.dto.TransferDto;
import soluciona.dev.bank.entity.Transfer;
import soluciona.dev.bank.service.TransferService;

import java.util.List;

@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto dto) {
        var resp = transferService.transfer(dto);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/transfer")
    public ResponseEntity<List<Transfer>> getAllTransfers() {
        List<Transfer> transfers = transferService.findAll();
        return ResponseEntity.ok(transfers);
    }

    @GetMapping("/transfer/sender/{cpfCnpj}")
    public ResponseEntity<List<Transfer>> getTransfersBySender(@PathVariable String cpfCnpj) {
        List<Transfer> transfers = transferService.findBySenderCpfCnpj(cpfCnpj);
        return ResponseEntity.ok(transfers);
    }

    @GetMapping("/transfer/receiver/{cpfCnpj}")
    public ResponseEntity<List<Transfer>> getTransfersByReceiver(@PathVariable String cpfCnpj) {
        List<Transfer> transfers = transferService.findByReceiverCpfCnpj(cpfCnpj);
        return ResponseEntity.ok(transfers);
    }
}