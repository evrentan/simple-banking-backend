package evrentan.example.simplebankingbackend.dto.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class BankAccount {

    private String accountNumber;
    private String owner;
    private BigDecimal balance;
    private LocalDateTime createdDate;
}
