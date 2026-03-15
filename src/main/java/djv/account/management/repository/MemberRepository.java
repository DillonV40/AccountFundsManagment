package djv.account.management.repository;

import djv.account.management.entity.MemberEntity;
import djv.account.management.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberEntity, BigInteger> {
    MemberEntity findByMemberId(UUID memberId);

}
