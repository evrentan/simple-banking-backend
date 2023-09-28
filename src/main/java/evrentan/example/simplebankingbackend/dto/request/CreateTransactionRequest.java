package evrentan.example.simplebankingbackend.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class CreateTransactionRequest {

    private BigDecimal amount;
}
