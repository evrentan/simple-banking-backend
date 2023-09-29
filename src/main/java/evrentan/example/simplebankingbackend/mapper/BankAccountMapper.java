package evrentan.example.simplebankingbackend.mapper;

import evrentan.example.simplebankingbackend.dto.model.BankAccount;
import evrentan.example.simplebankingbackend.dto.request.CreateBankAccountRequest;
import evrentan.example.simplebankingbackend.dto.response.CreateBankAccountResponse;
import evrentan.example.simplebankingbackend.entity.BankAccountEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BankAccountMapper {

    public static BankAccount toDto(BankAccountEntity bankAccountEntity) {
        if (Objects.isNull(bankAccountEntity))
            return null;

        return BankAccount.builder()
                .id(bankAccountEntity.getId())
                .accountNumber(bankAccountEntity.getAccountNumber())
                .owner(bankAccountEntity.getOwner())
                .balance(bankAccountEntity.getBalance())
                .createdDate(bankAccountEntity.getCreatedDate())
                .build();
    }

    public static BankAccountEntity toEntity(BankAccount bankAccount) {
        if (Objects.isNull(bankAccount))
            return null;

        return BankAccountEntity.builder()
                .accountNumber(bankAccount.getAccountNumber())
                .owner(bankAccount.getOwner())
                .balance(bankAccount.getBalance())
                .build();
    }

    public static BankAccountEntity toEntity(CreateBankAccountRequest createBankAccountRequest) {
        if (Objects.isNull(createBankAccountRequest))
            return null;

        return BankAccountEntity.builder()
                .accountNumber(createBankAccountRequest.getAccountNumber())
                .owner(createBankAccountRequest.getOwner())
                .balance(createBankAccountRequest.getBalance())
                .build();
    }

    public static List<BankAccount> toDtoList(List<BankAccountEntity> bankAccountEntityList) {
        if (bankAccountEntityList.isEmpty())
            return Collections.emptyList();

        return bankAccountEntityList.stream()
                .map(BankAccountMapper::toDto)
                .toList();
    }

    public static List<BankAccountEntity> toEntityList(List<BankAccount> bankAccountList) {
        if (bankAccountList.isEmpty())
            return Collections.emptyList();

        return bankAccountList.stream()
                .map(BankAccountMapper::toEntity)
                .toList();
    }

    public static CreateBankAccountResponse toCreateBankAccountResponse(BankAccountEntity bankAccountEntity) {
        if (Objects.isNull(bankAccountEntity))
            return null;

        return CreateBankAccountResponse.builder()
                .approvalCode(bankAccountEntity.getId())
                .build();
    }
}
