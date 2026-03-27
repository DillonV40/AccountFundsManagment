package djv.account.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_number", nullable = false)
    private int accountNumber;

    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Column(name="member_id", nullable=false)
    private UUID memberId;

    @Column(name="account_type", nullable=false)
    private String accountType;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date")
    private LocalDateTime updatedAt;

    @Column(name = "amount", nullable = false)
    private double amount;

}
