package ma.youssef.bankaccount_management_backend.repositories;

import ma.youssef.bankaccount_management_backend.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
    List<AccountOperation> findByBankAccountId(String accountId);
    Page findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
}
