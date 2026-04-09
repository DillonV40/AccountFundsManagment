package djv.account.management.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountCreationResponse {


    public int responseCode;
    public String statusMessage;
    public int id;

}
