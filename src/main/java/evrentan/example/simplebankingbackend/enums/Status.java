package evrentan.example.simplebankingbackend.enums;

public enum Status {
    OK("OK"),
    NOK("NOK");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
