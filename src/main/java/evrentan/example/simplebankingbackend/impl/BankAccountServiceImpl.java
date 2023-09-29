package evrentan.example.simplebankingbackend.impl;

import evrentan.example.simplebankingbackend.constant.ErrorMessage;
import evrentan.example.simplebankingbackend.dto.model.DepositTransaction;
import evrentan.example.simplebankingbackend.dto.model.WithdrawalTransaction;
import evrentan.example.simplebankingbackend.dto.request.CreateBankAccountRequest;
import evrentan.example.simplebankingbackend.dto.request.CreateTransactionRequest;
import evrentan.example.simplebankingbackend.dto.response.CreateBankAccountResponse;
import evrentan.example.simplebankingbackend.dto.response.CreateTransactionResponse;
import evrentan.example.simplebankingbackend.entity.BankAccountEntity;
import evrentan.example.simplebankingbackend.entity.BankAccountTransactionEntity;
import evrentan.example.simplebankingbackend.entity.TransactionEntity;
import evrentan.example.simplebankingbackend.enums.Status;
import evrentan.example.simplebankingbackend.exception.NotEnoughMoneyException;
import evrentan.example.simplebankingbackend.mapper.BankAccountMapper;
import evrentan.example.simplebankingbackend.mapper.TransactionMapper;
import evrentan.example.simplebankingbackend.repository.BankAccountRepository;
import evrentan.example.simplebankingbackend.repository.BankAccountTransactionRepository;
import evrentan.example.simplebankingbackend.repository.TransactionRepository;
import evrentan.example.simplebankingbackend.service.BankAccountService;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;
    private final BankAccountTransactionRepository bankAccountTransactionRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, TransactionRepository transactionRepository, BankAccountTransactionRepository bankAccountTransactionRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
        this.bankAccountTransactionRepository = bankAccountTransactionRepository;
    }

    /**
     * @param createBankAccountRequest
     * @return
     */
    @Override
    public CreateBankAccountResponse createBankAccount(CreateBankAccountRequest createBankAccountRequest) {

        BankAccountEntity bankAccountEntity = this.bankAccountRepository.save(BankAccountMapper.toEntity(createBankAccountRequest));
        CreateBankAccountResponse createBankAccountResponse = BankAccountMapper.toCreateBankAccountResponse(bankAccountEntity);
        createBankAccountResponse.setStatus(Status.OK.getStatus());
        return createBankAccountResponse;
    }

    /**
     * @param accountNumber
     * @param createTransactionRequest
     * @return
     */
    @Override
    public CreateTransactionResponse depositMoney(String accountNumber, CreateTransactionRequest createTransactionRequest) {
        BankAccountEntity bankAccountEntity = this.bankAccountRepository.findByAccountNumber(accountNumber);
        
        bankAccountEntity.setBalance(bankAccountEntity.getBalance().add(createTransactionRequest.getAmount()));
        this.bankAccountRepository.save(bankAccountEntity);

        DepositTransaction depositTransaction = DepositTransaction.builder()
                .amount(createTransactionRequest.getAmount())
                .build();

        return this.executeTransaction(bankAccountEntity, TransactionMapper.toEntity(depositTransaction));
    }

    /**
     * @param accountNumber
     * @param createTransactionRequest
     * @return
     */
    @Override
    public CreateTransactionResponse withdrawMoney(String accountNumber, CreateTransactionRequest createTransactionRequest) {
        BankAccountEntity bankAccountEntity = this.bankAccountRepository.findByAccountNumber(accountNumber);

        this.checkBankAccountBalance(createTransactionRequest, bankAccountEntity);

        bankAccountEntity.setBalance(bankAccountEntity.getBalance().subtract(createTransactionRequest.getAmount()));

        this.bankAccountRepository.save(bankAccountEntity);

        WithdrawalTransaction withdrawalTransaction = WithdrawalTransaction.builder()
                .amount(createTransactionRequest.getAmount())
                .build();

        return this.executeTransaction(bankAccountEntity, TransactionMapper.toEntity(withdrawalTransaction));
    }

    private CreateTransactionResponse executeTransaction(BankAccountEntity bankAccountEntity, TransactionEntity entity) {

        this.transactionRepository.save(entity);

        BankAccountTransactionEntity bankAccountTransactionEntity = BankAccountTransactionEntity.builder()
                .bankAccountId(bankAccountEntity.getId())
                .transactionId(entity.getId())
                .build();

        this.bankAccountTransactionRepository.save(bankAccountTransactionEntity);

        return CreateTransactionResponse.builder()
                .approvalCode(entity.getId())
                .status(Status.OK.getStatus())
                .build();
    }

    private void checkBankAccountBalance(CreateTransactionRequest createTransactionRequest, BankAccountEntity bankAccountEntity) {
        if (bankAccountEntity.getBalance().compareTo(createTransactionRequest.getAmount()) < 0) {
            throw new NotEnoughMoneyException(ErrorMessage.NOT_ENOUGH_MONEY);
        }
    }
}
