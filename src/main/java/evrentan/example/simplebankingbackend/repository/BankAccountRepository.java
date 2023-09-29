package evrentan.example.simplebankingbackend.repository;

import evrentan.example.simplebankingbackend.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, UUID> {

    BankAccountEntity findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);
}
