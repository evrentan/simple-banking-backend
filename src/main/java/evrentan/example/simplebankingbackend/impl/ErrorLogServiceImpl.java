package evrentan.example.simplebankingbackend.impl;

import evrentan.example.simplebankingbackend.constant.ErrorMessage;
import evrentan.example.simplebankingbackend.dto.model.ErrorLog;
import evrentan.example.simplebankingbackend.exception.BankAccountExistsException;
import evrentan.example.simplebankingbackend.exception.NoBankAccountFoundException;
import evrentan.example.simplebankingbackend.exception.NotEnoughMoneyException;
import evrentan.example.simplebankingbackend.queue.producer.ErrorLogProducer;
import evrentan.example.simplebankingbackend.service.ErrorLogService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ErrorLogServiceImpl implements ErrorLogService {

    private final ErrorLogProducer errorLogProducer;

    public ErrorLogServiceImpl(ErrorLogProducer errorLogProducer) {
        this.errorLogProducer = errorLogProducer;
    }

    /**
     * @param httpStatus
     * @param error
     * @param <T>
     */
    @Override
    public <T> void logError(HttpStatus httpStatus, T error) {
        ErrorLog errorLog = ErrorLog.builder()
                .type(error.getClass().getSimpleName())
                .httpStatusCode(httpStatus.value())
                .message(error instanceof Exception exception ? exception.getMessage() : ErrorMessage.UNKNOWN_ERROR)
                .accountNumber(this.getAccountNumber(error))
                .build();

        this.errorLogProducer.sendErrorLog(errorLog);
    }

    private String getAccountNumber(Object error) {
        return switch (error) {
            case BankAccountExistsException bankAccountExistsException -> bankAccountExistsException.getAccountNumber();
            case NoBankAccountFoundException noBankAccountFoundException -> noBankAccountFoundException.getAccountNumber();
            case NotEnoughMoneyException notEnoughMoneyException -> notEnoughMoneyException.getAccountNumber();
            default -> null;
        };
    }
}
