package evrentan.example.simplebankingbackend.exception;

import evrentan.example.simplebankingbackend.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorResponse> notEnoughMoneyException(final Exception exception){
        var customRestError = ErrorResponse.builder()
                .message(exception.getMessage())
                .build();

        return responseEntity(HttpStatus.BAD_REQUEST, customRestError);
    }

    @ExceptionHandler(BankAccountExistsException.class)
    public ResponseEntity<ErrorResponse> bankAccountExistsException(final Exception exception){
        var customRestError = ErrorResponse.builder()
                .message(exception.getMessage())
                .build();

        return responseEntity(HttpStatus.CONFLICT, customRestError);
    }

    private static ResponseEntity<ErrorResponse> responseEntity(HttpStatus httpStatus, ErrorResponse errorResponse){
        return ResponseEntity.status(httpStatus.value())
                .body(errorResponse);
    }
}