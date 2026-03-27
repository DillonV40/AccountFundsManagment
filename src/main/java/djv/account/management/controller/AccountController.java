package djv.account.management.controller;

import djv.account.management.model.Account;
import djv.account.management.model.Member;
import djv.account.management.model.request.AccountCreationRequest;
import djv.account.management.model.request.MemberCreationRequest;
import djv.account.management.service.AccountService;
import djv.account.management.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account-management/")
public class AccountController {

    private final MemberService memberService;
    private final AccountService accountService;

    public AccountController(MemberService memberService, AccountService accountService) {
        this.memberService = memberService;
        this.accountService = accountService;
    }

    @PostMapping("member-creation")
    public String createMember(@RequestBody MemberCreationRequest memberCreationRequest) {
        return memberService.createMember(memberCreationRequest);
    }

    @PostMapping("account-creation")
    public int accountCreation(@RequestBody AccountCreationRequest accountCreationRequest) {
        return accountService.createAccount(accountCreationRequest);
    }

}
