package soluciona.dev.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soluciona.dev.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
