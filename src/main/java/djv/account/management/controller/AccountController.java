package djv.account.management.controller;

import djv.account.management.model.Account;
import djv.account.management.model.AppResponse;
import djv.account.management.model.Member;
import djv.account.management.model.request.AccountCreationRequest;
import djv.account.management.model.request.MemberCreationRequest;
import djv.account.management.service.AccountService;
import djv.account.management.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Operation(
            summary = "Enroll a new user")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Member enrolled successfully"),
                    @ApiResponse(
                            responseCode = "200",
                            description = "Member is already enrolled"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request data"),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Server Error"
                    )
            })
    @PostMapping("member-creation")
    public String createMember(@RequestBody MemberCreationRequest memberCreationRequest) {
        return memberService.createMember(memberCreationRequest);
    }

    @PostMapping("account-creation")
    public ResponseEntity<AppResponse> accountCreation(@RequestBody AccountCreationRequest accountCreationRequest) {


        return new ResponseEntity<>(accountService.createAccount(accountCreationRequest), HttpStatus.CREATED);
    }

}
