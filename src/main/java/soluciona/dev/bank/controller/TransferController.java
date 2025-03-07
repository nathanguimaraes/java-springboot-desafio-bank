package soluciona.dev.bank.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soluciona.dev.bank.controller.dto.TransferDto;
import soluciona.dev.bank.service.TransferService;
import soluciona.dev.bank.entity.Transfer;

import java.util.List;


@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto dto){

        var resp= transferService.transfer(dto);

        return ResponseEntity.ok(resp);
    }
}
