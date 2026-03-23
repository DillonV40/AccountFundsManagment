package djv.account.management.service;

import djv.account.management.entity.MemberEntity;
import djv.account.management.model.Member;
import djv.account.management.model.request.MemberCreationRequest;
import djv.account.management.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Log4j2
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String createMember(MemberCreationRequest memberCreationRequest) {

        // check if they exist before saving
        if (memberExist(memberCreationRequest.getEmail())) {
            log.debug("Member exists");
            return memberRepository.findByEmail(memberCreationRequest.getEmail()).getMemberId().toString();
        } else {
            log.debug("Member does not exists");
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
                .dateOfBirth(memberCreationRequest.getDateOfBirth())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
