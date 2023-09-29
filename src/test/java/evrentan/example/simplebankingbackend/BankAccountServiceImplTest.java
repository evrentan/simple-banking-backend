package evrentan.example.simplebankingbackend;

import evrentan.example.simplebankingbackend.dto.request.CreateBankAccountRequest;
import evrentan.example.simplebankingbackend.dto.request.CreateTransactionRequest;
import evrentan.example.simplebankingbackend.dto.response.CreateBankAccountResponse;
import evrentan.example.simplebankingbackend.dto.response.CreateTransactionResponse;
import evrentan.example.simplebankingbackend.entity.BankAccountEntity;
import evrentan.example.simplebankingbackend.enums.Status;
import evrentan.example.simplebankingbackend.exception.BankAccountExistsException;
import evrentan.example.simplebankingbackend.impl.BankAccountServiceImpl;
import evrentan.example.simplebankingbackend.repository.BankAccountRepository;
import evrentan.example.simplebankingbackend.repository.BankAccountTransactionRepository;
import evrentan.example.simplebankingbackend.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BankAccountServiceImplTest {

    @InjectMocks
    private BankAccountServiceImpl bankAccountService;

    @Mock
    private BankAccountRepository bankAccountRepository;
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private BankAccountTransactionRepository bankAccountTransactionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Create Bank Account Test - Success Case")
    void testCreateBankAccount_Success() {

        CreateBankAccountRequest request = CreateBankAccountRequest.builder()
                .accountNumber("123456789")
                .owner("Test Account")
                .balance(BigDecimal.valueOf(100))
                .build();

        BankAccountEntity savedBankAccountEntity = BankAccountEntity.builder()
                .id(UUID.randomUUID())
                .accountNumber("123456789")
                .owner("Test Account")
                .balance(BigDecimal.valueOf(100))
                .build();

        CreateBankAccountResponse expectedResponse = CreateBankAccountResponse.builder()
                        .status(Status.OK.getStatus())
                        .approvalCode(savedBankAccountEntity.getId())
                        .build();

        when(bankAccountRepository.existsByAccountNumber(request.getAccountNumber())).thenReturn(false);

        when(bankAccountRepository.save(any(BankAccountEntity.class))).thenReturn(savedBankAccountEntity);

        CreateBankAccountResponse actualResponse = bankAccountService.createBankAccount(request);


        verify(bankAccountRepository, times(1)).existsByAccountNumber(request.getAccountNumber());
        verify(bankAccountRepository, times(1)).save(any(BankAccountEntity.class));

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Create Bank Account Test - Account Exists Case")
    void testCreateBankAccount_AccountExists() {

        CreateBankAccountRequest request = CreateBankAccountRequest.builder()
                .accountNumber("123456789")
                .owner("Test Account")
                .balance(BigDecimal.valueOf(100))
                .build();

        when(bankAccountRepository.existsByAccountNumber(request.getAccountNumber())).thenReturn(true);

        assertThrows(BankAccountExistsException.class, () -> bankAccountService.createBankAccount(request));

        verify(bankAccountRepository, times(1)).existsByAccountNumber(request.getAccountNumber());
        verify(bankAccountRepository, never()).save(any(BankAccountEntity.class));
    }

    @Test
    @DisplayName("Deposit Money Test - Success Case")
    void testDepositMoney_Success() {
        String accountNumber = "123456789";

        CreateTransactionRequest request = CreateTransactionRequest.builder()
                .amount(BigDecimal.valueOf(10))
                .build();

        BankAccountEntity existingBankAccountEntity = BankAccountEntity.builder()
                .id(UUID.randomUUID())
                .accountNumber("123456789")
                .owner("Test Account")
                .balance(BigDecimal.valueOf(100))
                .createdDate(LocalDateTime.now())
                .build();


        when(bankAccountRepository.findByAccountNumber(accountNumber)).thenReturn(existingBankAccountEntity);

        CreateTransactionResponse response = bankAccountService.depositMoney(accountNumber, request);

        verify(bankAccountRepository).save(existingBankAccountEntity);

        assertEquals(Status.OK.getStatus(), response.getStatus());
        assertEquals(BigDecimal.valueOf(110), existingBankAccountEntity.getBalance());
    }

    @Test
    @DisplayName("Withdraw Money Test - Success Case")
    void testWithdrawMoney_Success() {
        String accountNumber = "123456789";

        CreateTransactionRequest request = CreateTransactionRequest.builder()
                .amount(BigDecimal.valueOf(10))
                .build();

        BankAccountEntity existingBankAccountEntity = BankAccountEntity.builder()
                .id(UUID.randomUUID())
                .accountNumber("123456789")
                .owner("Test Account")
                .balance(BigDecimal.valueOf(100))
                .createdDate(LocalDateTime.now())
                .build();


        when(bankAccountRepository.findByAccountNumber(accountNumber)).thenReturn(existingBankAccountEntity);

        CreateTransactionResponse response = bankAccountService.withdrawMoney(accountNumber, request);

        verify(bankAccountRepository).save(existingBankAccountEntity);

        assertEquals(Status.OK.getStatus(), response.getStatus());
        assertEquals(BigDecimal.valueOf(90), existingBankAccountEntity.getBalance());
    }
}
