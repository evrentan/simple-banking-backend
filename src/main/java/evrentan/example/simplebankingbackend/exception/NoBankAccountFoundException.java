package evrentan.example.simplebankingbackend.exception;

public class NoBankAccountFoundException extends RuntimeException {

    private String message;

    public NoBankAccountFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getExMessage() {
        return this.message;
    }
}
