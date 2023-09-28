package evrentan.example.simplebankingbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bank_account")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Basic
    @Column(name = "account_number")
    private String accountNumber;

    @Basic
    @Column(name = "owner")
    private String owner;

    @Basic
    @Column(name = "balance")
    private BigDecimal balance;

    @Basic
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
}
