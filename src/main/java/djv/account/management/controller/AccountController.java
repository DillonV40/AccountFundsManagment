package djv.account.management.controller;

import djv.account.management.model.Account;
import djv.account.management.model.Member;
import djv.account.management.service.AccountService;
import djv.account.management.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account-management/")
@AllArgsConstructor
public class AccountController {

    private final MemberService memberService;
    private final AccountService accountService;

    @PostMapping("member-creation")
    public String createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PostMapping("account-creation")
    public int accountCreation(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

}
