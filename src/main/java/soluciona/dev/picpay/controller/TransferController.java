package soluciona.dev.picpay.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import soluciona.dev.picpay.controller.dto.TransferDto;
import soluciona.dev.picpay.service.TransferService;
import soluciona.dev.picpay.entity.Transfer;


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
