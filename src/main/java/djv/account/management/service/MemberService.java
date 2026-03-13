package djv.account.management.service;

import djv.account.management.model.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public String createMember(Member member) {
        return member.getMemberId();
    }
}
