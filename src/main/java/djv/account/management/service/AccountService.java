package djv.account.management.service;

import djv.account.management.entity.AccountEntity;
import djv.account.management.enums.AccountTypes;
import djv.account.management.model.Account;
import djv.account.management.model.AppResponse;
import djv.account.management.model.Member;
import djv.account.management.model.request.AccountCreationRequest;
import djv.account.management.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final MemberService memberService;

    public AppResponse createAccount(AccountCreationRequest accountCreationRequest) {

        // check if member exists
        if (memberService.memberExistById(accountCreationRequest.getMemberId())) {
            AccountEntity newEntity = accountRepository.save(createEntity(accountCreationRequest));
            return buildResponseCreated(newEntity.getAccountNumber());
        }
        else {
            // TODO: FIX LATER
            System.out.println("Maaaaaaan what stop sign ");
            return new AppResponse(500, "member does not exist", accountCreationRequest.getMemberId());
        }

    }

    private AppResponse buildResponseCreated(int createdAccount) {
        AppResponse newResponse = new AppResponse();
        newResponse.setResponseCode(201);
        newResponse.setId(createdAccount);
        newResponse.setStatusMessage("Created new account for member");
        return newResponse;
    }


    private AccountEntity createEntity(AccountCreationRequest account) {
        return AccountEntity.builder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .memberId(account.getMemberId())
                .accountType(account.getAccountType())
                .amount(account.getAmount())
                .build();
    }
}
