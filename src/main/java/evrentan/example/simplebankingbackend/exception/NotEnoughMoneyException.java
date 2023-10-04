package evrentan.example.simplebankingbackend.exception;

import lombok.Getter;

@Getter
public class NotEnoughMoneyException extends RuntimeException {

    private String message;
    private String accountNumber;

    public NotEnoughMoneyException(String message, String accountNumber) {
        super(message);
        this.message = message;
        this.accountNumber = accountNumber;
    }
}
