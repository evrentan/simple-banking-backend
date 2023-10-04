package evrentan.example.simplebankingbackend.mapper;

import evrentan.example.simplebankingbackend.dto.model.ErrorLog;
import evrentan.example.simplebankingbackend.entity.ErrorLogEntity;

import java.util.List;
import java.util.Objects;

public class ErrorLogMapper {

    public static ErrorLogEntity toEntity(ErrorLog errorLog) {
        if (Objects.isNull(errorLog)) {
            return null;
        }

        return ErrorLogEntity.builder()
                .id(errorLog.getId())
                .type(errorLog.getType())
                .httpStatusCode(errorLog.getHttpStatusCode())
                .message(errorLog.getMessage())
                .createdDate(errorLog.getCreatedDate())
                .accountNumber(errorLog.getAccountNumber())
                .build();
    }

    public static ErrorLog toDto(ErrorLogEntity errorLogEntity) {
        if (Objects.isNull(errorLogEntity)) {
            return null;
        }

        return ErrorLog.builder()
                .id(errorLogEntity.getId())
                .type(errorLogEntity.getType())
                .httpStatusCode(errorLogEntity.getHttpStatusCode())
                .message(errorLogEntity.getMessage())
                .createdDate(errorLogEntity.getCreatedDate())
                .accountNumber(errorLogEntity.getAccountNumber())
                .build();
    }

    public static List<ErrorLogEntity> toEntityList(List<ErrorLog> errorLogList) {
        if (errorLogList.isEmpty()) {
            return null;
        }

        return errorLogList.stream()
                .map(ErrorLogMapper::toEntity)
                .toList();
    }

    public static List<ErrorLog> toDtoList(List<ErrorLogEntity> errorLogEntityList) {
        if (errorLogEntityList.isEmpty()) {
            return null;
        }

        return errorLogEntityList.stream()
                .map(ErrorLogMapper::toDto)
                .toList();
    }
}
