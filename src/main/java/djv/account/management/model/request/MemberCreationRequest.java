package djv.account.management.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberCreationRequest{

    public String firstName;
    public String lastName;
    public String email;
}
