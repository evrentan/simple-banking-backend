package evrentan.example.simplebankingbackend.exception;

import lombok.Getter;

@Getter
public class NoBankAccountFoundException extends RuntimeException {

    private String message;
    private String accountNumber;

    public NoBankAccountFoundException(String message, String accountNumber) {
        super(message);
        this.message = message;
        this.accountNumber = accountNumber;
    }
}
