package djv.account.management.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {


    public int id;
    public UUID memberId;
    public String accountType;
    public int accountNumber;
    public LocalDateTime createdDate;
    public LocalDateTime modifiedDate;
    public double amount;


}
