package djv.account.management.repository;

import djv.account.management.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AccountRepository extends JpaRepository<AccountEntity, BigInteger> {

    AccountEntity findByAccountNumber(BigInteger accountNumber);
}
