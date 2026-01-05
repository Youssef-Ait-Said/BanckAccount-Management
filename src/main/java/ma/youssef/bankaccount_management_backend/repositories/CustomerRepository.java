package ma.youssef.bankaccount_management_backend.repositories;

import ma.youssef.bankaccount_management_backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContains(String keyword);
}
