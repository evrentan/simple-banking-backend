package evrentan.example.simplebankingbackend.mapper;

import evrentan.example.simplebankingbackend.dto.model.DepositTransaction;
import evrentan.example.simplebankingbackend.dto.model.Transaction;
import evrentan.example.simplebankingbackend.dto.model.WithdrawalTransaction;
import evrentan.example.simplebankingbackend.entity.TransactionEntity;
import evrentan.example.simplebankingbackend.enums.TransactionType;

import java.util.List;

public class TransactionMapper {

    public static Transaction toDto(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .approvalCode(transactionEntity.getId())
                .date(transactionEntity.getDate().toString())
                .amount(transactionEntity.getAmount())
                .type(transactionEntity.getType())
                .build();
    }

    public static TransactionEntity toEntity(DepositTransaction depositTransaction) {
        return TransactionEntity.builder()
                .id(depositTransaction.getApprovalCode())
                .amount(depositTransaction.getAmount())
                .type(TransactionType.DEPOSIT.getType())
                .build();
    }

    public static TransactionEntity toEntity(WithdrawalTransaction withdrawalTransaction) {
        return TransactionEntity.builder()
                .id(withdrawalTransaction.getApprovalCode())
                .amount(withdrawalTransaction.getAmount())
                .type(TransactionType.WITHDRAWAL.getType())
                .build();
    }

    public static List<Transaction> toDtoList(List<TransactionEntity> transactionEntityList) {
        return transactionEntityList.stream()
                .map(TransactionMapper::toDto)
                .toList();
    }
}
