package djv.account.management.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {

    public int id;
    public String memberId;
    public String firstName;
    public String lastName;
    public LocalDateTime createdDate;
    public LocalDateTime modifiedDate;
    public LocalDate dateOfBirth;

    public List<Account> accounts;

    public Member(int id, String memberId, String firstName, String lastName) {
        this.id = id;
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
