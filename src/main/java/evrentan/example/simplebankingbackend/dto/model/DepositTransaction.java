package evrentan.example.simplebankingbackend.dto.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class DepositTransaction extends Transaction {
}
