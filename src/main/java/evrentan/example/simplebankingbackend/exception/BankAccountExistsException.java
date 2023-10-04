package evrentan.example.simplebankingbackend.exception;

import lombok.Getter;

@Getter
public class    BankAccountExistsException extends RuntimeException {

    private String message;
    private String accountNumber;

    public BankAccountExistsException(String message, String accountNumber) {
        super(message);
        this.message = message;
        this.accountNumber = accountNumber;
    }
}
