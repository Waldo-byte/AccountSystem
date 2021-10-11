package za.ac.nwu.accountsys.repo.persistence;

import domain.persistance.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser,Long> {
}
