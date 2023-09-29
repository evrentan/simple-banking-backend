package evrentan.example.simplebankingbackend.dto.response;

import evrentan.example.simplebankingbackend.enums.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class ErrorResponse {

    @Builder.Default
    private String status = Status.NOK.getStatus();
    private String message;
}
