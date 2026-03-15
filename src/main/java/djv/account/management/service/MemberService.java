package djv.account.management.service;

import djv.account.management.entity.MemberEntity;
import djv.account.management.model.Member;
import djv.account.management.model.request.MemberCreationRequest;
import djv.account.management.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String createMember(MemberCreationRequest memberCreationRequest) {

        // check if they exist before saving
        if (memberExist(memberCreationRequest.getEmail())) {
            System.out.println("Member Exists!!!");
            return memberRepository.findByEmail(memberCreationRequest.getEmail()).getMemberId().toString();
        } else {
            System.out.println("Member does not exist!!");
            MemberEntity newMember = createNewEntity(memberCreationRequest);
            memberRepository.save(newMember);
            return newMember.getMemberId().toString();
        }
    }

    private boolean memberExist(String email) {
        return memberRepository.findByEmail(email) != null;
    }

    private MemberEntity createNewEntity(MemberCreationRequest memberCreationRequest) {
        UUID memberId = UUID.randomUUID();

        return MemberEntity.builder()
                .memberId(memberId)
                .firstName(memberCreationRequest.getFirstName())
                .lastName(memberCreationRequest.getLastName())
                .email(memberCreationRequest.getEmail())
                .build();
    }
}
