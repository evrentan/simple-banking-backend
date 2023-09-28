package evrentan.example.simplebankingbackend.dto.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class BankAccountTransaction {

    private UUID id;
    private UUID bankAccountId;
    private UUID transactionId;
}
