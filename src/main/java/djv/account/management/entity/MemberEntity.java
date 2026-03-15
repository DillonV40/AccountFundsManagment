package djv.account.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "members")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberEntity {

    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Id
    @Column(name="member_id", nullable=false)
    private UUID memberId;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name", nullable=false)
    private String lastName;

    @Column(name="email", nullable=false)
    private String email;
}
