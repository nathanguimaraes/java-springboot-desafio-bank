package soluciona.dev.bank.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soluciona.dev.bank.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findBySenderIdOrReceiverId(Long senderId, Long receiverId);

}