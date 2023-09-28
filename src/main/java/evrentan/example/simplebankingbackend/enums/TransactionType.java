package evrentan.example.simplebankingbackend.enums;

public enum TransactionType {
    DEPOSIT("DepositTransaction"),
    WITHDRAWAL("WithdrawalTransaction"),
    BILL_PAYMENT("BillPaymentTransaction");

    private final String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static String getType(String type) {
        return TransactionType.valueOf(type).getType();
    }
}
