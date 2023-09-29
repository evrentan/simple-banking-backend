package evrentan.example.simplebankingbackend.exception;

public class BankAccountExistsException extends RuntimeException {

    private String message;

    public BankAccountExistsException(String message) {
        super(message);
        this.message = message;
    }

    public String getExMessage() {
        return this.message;
    }
}
