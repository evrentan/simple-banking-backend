package evrentan.example.simplebankingbackend.dto.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class BankAccount {

    private UUID id;
    private String accountNumber;
    private String owner;
    private BigDecimal balance;
    private LocalDateTime createdDate;
}
