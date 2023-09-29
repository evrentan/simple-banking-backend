package evrentan.example.simplebankingbackend.dto.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@SuperBuilder
public class Transaction {

    private String date;
    private BigDecimal amount;
    private String type;
    private UUID approvalCode;
}
