package za.ac.nwu.accountsys.repo.persistence;

import domain.persistance.AccountTyoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountTyoe,Long>{


}
