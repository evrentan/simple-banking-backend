package evrentan.example.simplebankingbackend.controller;

import evrentan.example.simplebankingbackend.dto.request.CreateBankAccountRequest;
import evrentan.example.simplebankingbackend.dto.request.CreateTransactionRequest;
import evrentan.example.simplebankingbackend.dto.response.CreateBankAccountResponse;
import evrentan.example.simplebankingbackend.dto.response.CreateTransactionResponse;
import evrentan.example.simplebankingbackend.dto.response.GetBankAccountDetailResponse;
import evrentan.example.simplebankingbackend.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account/v1", produces = "application/json", consumes = "application/json")
public class AccountController {

    private final BankAccountService bankAccountService;

    public AccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping(value = "/createBankAccount")
    @Operation(summary = "Creat an EventEntity")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Bank Account Created"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<CreateBankAccountResponse> createBankAccount(@RequestBody @NotNull CreateBankAccountRequest createBankAccountRequest) {
        return ResponseEntity.ok(this.bankAccountService.createBankAccount(createBankAccountRequest));
    }

    @PostMapping(value = "/credit/{accountNumber}")
    @Operation(summary = "Deposit Money to Bank Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Deposit Money"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<CreateTransactionResponse> depositMoney(@PathVariable("accountNumber") String accountNumber, @RequestBody @NotNull CreateTransactionRequest createTransactionRequest) {
        return ResponseEntity.ok(this.bankAccountService.depositMoney(accountNumber, createTransactionRequest));
    }

    @PostMapping(value = "/debit/{accountNumber}")
    @Operation(summary = "Withdraw Money from Bank Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Withdraw Money"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<CreateTransactionResponse> withdrawMoney(@PathVariable("accountNumber") String accountNumber, @RequestBody @NotNull CreateTransactionRequest createTransactionRequest) {
        return ResponseEntity.ok(this.bankAccountService.withdrawMoney(accountNumber, createTransactionRequest));
    }

    @GetMapping(value = "/{accountNumber}")
    @Operation(summary = "Get Bank Account Detail")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Get Bank Account Detail"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<GetBankAccountDetailResponse> getBankAccountDetail(@PathVariable("accountNumber") String accountNumber) {
        return ResponseEntity.ok(this.bankAccountService.getBankAccountDetails(accountNumber));
    }
}
