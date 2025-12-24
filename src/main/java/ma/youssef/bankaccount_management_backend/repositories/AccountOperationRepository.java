package ma.youssef.bankaccount_management_backend.repositories;

import ma.youssef.bankaccount_management_backend.entities.AccountOperation;
import ma.youssef.bankaccount_management_backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
