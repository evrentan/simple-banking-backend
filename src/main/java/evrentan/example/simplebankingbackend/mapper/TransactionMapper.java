package evrentan.example.simplebankingbackend.mapper;

import evrentan.example.simplebankingbackend.dto.model.DepositTransaction;
import evrentan.example.simplebankingbackend.dto.model.WithdrawalTransaction;
import evrentan.example.simplebankingbackend.entity.TransactionEntity;
import evrentan.example.simplebankingbackend.enums.TransactionType;

public class TransactionMapper {

    public static TransactionEntity toEntity(DepositTransaction depositTransaction) {
        return TransactionEntity.builder()
                .id(depositTransaction.getApprovalCode())
                .date(depositTransaction.getDate())
                .amount(depositTransaction.getAmount())
                .type(TransactionType.DEPOSIT.getType())
                .build();
    }

    public static TransactionEntity toEntity(WithdrawalTransaction withdrawalTransaction) {
        return TransactionEntity.builder()
                .id(withdrawalTransaction.getApprovalCode())
                .date(withdrawalTransaction.getDate())
                .amount(withdrawalTransaction.getAmount())
                .type(TransactionType.WITHDRAWAL.getType())
                .build();
    }
}
