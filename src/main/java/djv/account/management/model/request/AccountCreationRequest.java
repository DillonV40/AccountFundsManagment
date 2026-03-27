package djv.account.management.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountCreationRequest {

    public UUID memberId;
    public String accountType;
    public double amount;

}
