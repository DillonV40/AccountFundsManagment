package djv.account.management.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    public int id;
    public String memberId;
    public int accountNumber;
    public LocalDateTime createdDate;
    public LocalDateTime modifiedDate;
    public double amount;


}
