package evrentan.example.simplebankingbackend.repository;

import evrentan.example.simplebankingbackend.entity.ErrorLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLogEntity, UUID> {
}
