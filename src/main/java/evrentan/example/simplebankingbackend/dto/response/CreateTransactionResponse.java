package evrentan.example.simplebankingbackend.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class CreateTransactionResponse {
    private String status;
    private UUID approvalCode;
}
