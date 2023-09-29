package evrentan.example.simplebankingbackend.exception;

public class NotEnoughMoneyException extends RuntimeException {

    private String message;

    public NotEnoughMoneyException(String message) {
        super(message);
        this.message = message;
    }

    public String getExMessage() {
        return this.message;
    }
}
