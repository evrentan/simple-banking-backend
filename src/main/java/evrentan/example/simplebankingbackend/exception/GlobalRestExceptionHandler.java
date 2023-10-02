package evrentan.example.simplebankingbackend.exception;

import evrentan.example.simplebankingbackend.dto.model.ErrorLog;
import evrentan.example.simplebankingbackend.dto.response.ErrorResponse;
import evrentan.example.simplebankingbackend.queue.producer.ErrorLogProducer;
import evrentan.example.simplebankingbackend.service.ErrorLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    private final ErrorLogProducer errorLogProducer;
    private final ErrorLogService errorLogService;

    public GlobalRestExceptionHandler(ErrorLogProducer errorLogProducer, ErrorLogService errorLogService) {
        this.errorLogProducer = errorLogProducer;
        this.errorLogService = errorLogService;
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorResponse> notEnoughMoneyException(final Exception exception){
        var customRestError = ErrorResponse.builder()
                .message(exception.getMessage())
                .build();

        this.errorLogService.logError(HttpStatus.BAD_REQUEST, exception);

        return responseEntity(HttpStatus.BAD_REQUEST, customRestError);
    }

    @ExceptionHandler(BankAccountExistsException.class)
    public ResponseEntity<ErrorResponse> bankAccountExistsException(final Exception exception){
        var customRestError = ErrorResponse.builder()
                .message(exception.getMessage())
                .build();

        this.errorLogService.logError(HttpStatus.CONFLICT, exception);

        return responseEntity(HttpStatus.CONFLICT, customRestError);
    }

    @ExceptionHandler(NoBankAccountFoundException.class)
    public ResponseEntity<ErrorResponse> noBankAccountFoundException(final Exception exception){
        var customRestError = ErrorResponse.builder()
                .message(exception.getMessage())
                .build();

        this.errorLogService.logError(HttpStatus.NOT_FOUND, exception);

        return responseEntity(HttpStatus.NOT_FOUND, customRestError);
    }

    private ResponseEntity<ErrorResponse> responseEntity(HttpStatus httpStatus, ErrorResponse errorResponse){
        return ResponseEntity.status(httpStatus.value())
                .body(errorResponse);
    }

    private void sendErrorLog(HttpStatus httpStatus, final Exception exception) {
        ErrorLog errorLog = ErrorLog.builder()
                .type(exception.getClass().getSimpleName())
                .httpStatusCode(httpStatus.value())
                .message(exception.getMessage())
                .build();

        this.errorLogProducer.sendErrorLog(errorLog);
    }
}