package evrentan.example.simplebankingbackend.service;

import org.springframework.http.HttpStatus;

public interface ErrorLogService {

    <T> void logError(HttpStatus httpStatus, T error);
}
