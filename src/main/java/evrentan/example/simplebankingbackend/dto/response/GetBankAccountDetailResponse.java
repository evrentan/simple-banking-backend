package evrentan.example.simplebankingbackend.dto.response;

import evrentan.example.simplebankingbackend.entity.TransactionEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class GetBankAccountDetailResponse {

    private String accountNumber;
    private String owner;
    private BigDecimal balance;
    private LocalDateTime createdDate;
    private List<TransactionEntity> transactions;
}
