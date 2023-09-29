package evrentan.example.simplebankingbackend.dto.response;

import evrentan.example.simplebankingbackend.dto.model.Transaction;
import lombok.*;

import java.math.BigDecimal;
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
    private String createdDate;
    private List<Transaction> transactions;
}
