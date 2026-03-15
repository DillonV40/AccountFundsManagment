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

        MemberEntity newMember = createNewEntity(memberCreationRequest);
        memberRepository.save(newMember);

        return newMember.getMemberId().toString();
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
