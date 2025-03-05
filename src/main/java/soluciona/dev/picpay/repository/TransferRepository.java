package soluciona.dev.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soluciona.dev.picpay.entity.Transfer;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
