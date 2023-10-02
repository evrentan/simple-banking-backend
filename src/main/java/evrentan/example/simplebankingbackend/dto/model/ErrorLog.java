package evrentan.example.simplebankingbackend.dto.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class ErrorLog implements Serializable {

    private UUID id;
    private String type;
    private Integer httpStatusCode;
    private String message;
    private LocalDateTime createdDate;
}
