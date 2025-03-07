package soluciona.dev.bank.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soluciona.dev.bank.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findBySenderIdOrReceiverId(Long senderId, Long receiverId);

    @Query("SELECT t FROM Transfer t WHERE t.sender.cpfCnpj = :cpfCnpj")
    List<Transfer> findBySenderCpfCnpj(@Param("cpfCnpj") String cpfCnpj);

    @Query("SELECT t FROM Transfer t WHERE t.receiver.cpfCnpj = :cpfCnpj")
    List<Transfer> findByReceiverCpfCnpj(@Param("cpfCnpj") String cpfCnpj);
}