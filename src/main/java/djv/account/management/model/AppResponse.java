package djv.account.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppResponse {

    public int responseCode;
    public String statusMessage;
    public UUID memberId;
    public int id;

    public AppResponse(int responseCode, String statusMessage, UUID memberId) {
        this.responseCode = responseCode;
        this.statusMessage = statusMessage;
        this.memberId = memberId;
    }
}
