package za.ac.nwu.accountsys.repo.persistence;

import domain.persistance.AccountTransaction;
import domain.persistance.AccountTyoe;
import domain.persistance.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Long>{

    @Query(value =
            "SELECT " +
                    "actr " +
                    "FROM " +
                    "AccountTransaction " +
                    "actr " +
                    "WHERE " +
                    "actr.accountUser = :accountUser ")
    List<AccountTransaction> getMemberBalances(AccountUser accountUser);
}
