package evrentan.example.simplebankingbackend.service;

import evrentan.example.simplebankingbackend.dto.request.CreateBankAccountRequest;
import evrentan.example.simplebankingbackend.dto.request.CreateTransactionRequest;
import evrentan.example.simplebankingbackend.dto.response.CreateBankAccountResponse;
import evrentan.example.simplebankingbackend.dto.response.CreateTransactionResponse;
import evrentan.example.simplebankingbackend.dto.response.GetBankAccountDetailResponse;

public interface BankAccountService {

    CreateBankAccountResponse createBankAccount(CreateBankAccountRequest createBankAccountRequest);

    CreateTransactionResponse depositMoney(String accountNumber, CreateTransactionRequest createTransactionRequest);

    CreateTransactionResponse withdrawMoney(String accountNumber, CreateTransactionRequest createTransactionRequest);

    GetBankAccountDetailResponse getBankAccountDetails(String accountNumber);
}
