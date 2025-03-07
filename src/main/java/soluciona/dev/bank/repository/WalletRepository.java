package soluciona.dev.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soluciona.dev.bank.entity.Wallet;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
    Optional<Wallet> findByCpfCnpj(String cpfCnpj);
}