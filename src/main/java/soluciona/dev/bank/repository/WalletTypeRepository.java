package soluciona.dev.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soluciona.dev.bank.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
