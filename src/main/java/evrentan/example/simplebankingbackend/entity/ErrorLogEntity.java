package evrentan.example.simplebankingbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "error_log")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ErrorLogEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "http_status_code")
    private Integer httpStatusCode;

    @Basic
    @Column(name = "message")
    private String message;

    @Basic
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Basic
    @Column(name = "account_number")
    private String accountNumber;
}
