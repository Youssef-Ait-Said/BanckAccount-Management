package ma.youssef.bankaccount_management_backend.exceptions;

public class BalanceNotSfficientException extends Exception {
    public BalanceNotSfficientException(String message) {
        super(message);
    }
}
