package evrentan.example.simplebankingbackend.repository;

import evrentan.example.simplebankingbackend.entity.BankAccountTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransactionEntity, UUID> {
}
