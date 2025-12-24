package ma.youssef.bankaccount_management_backend;

import ma.youssef.bankaccount_management_backend.entities.*;
import ma.youssef.bankaccount_management_backend.enums.AccountStatus;
import ma.youssef.bankaccount_management_backend.enums.OperationType;
import ma.youssef.bankaccount_management_backend.repositories.AccountOperationRepository;
import ma.youssef.bankaccount_management_backend.repositories.BankAccountRepository;
import ma.youssef.bankaccount_management_backend.repositories.CustomerRepository;
import ma.youssef.bankaccount_management_backend.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountManagementBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountManagementBackendApplication.class, args);
    }

    //@Bean
    CommandLineRunner start(BankAccountRepository repository,
                            CustomerRepository customerRepository,
                            AccountOperationRepository accountOperationRepository,
                            BankAccountRepository bankAccountRepository) {

        return args -> {
            Stream.of("Youssef", "Yassine", "Houda").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(cust -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setCustomer(cust);
                currentAccount.setBalance(Math.random() * 600);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCurrency("Dh");
                currentAccount.setOverdraft(750);
                bankAccountRepository.save(currentAccount);
            });

            customerRepository.findAll().forEach(cust -> {
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setCustomer(cust);
                savingAccount.setBalance(Math.random() * 600);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setCurrency("Dh");
                savingAccount.setInterestRate(6.5);
                savingAccount.setStatus(AccountStatus.CREATED);
                bankAccountRepository.save(savingAccount);
            });

            bankAccountRepository.findAll().forEach(acc -> {
                for (int i = 0; i < 10; i++) {
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setAmount(Math.random() * 399);
                    accountOperation.setDate(new Date());
                    accountOperation.setType(Math.random()>0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }
            });

        };
    }

    @Bean
    CommandLineRunner  commandLineRunner(BankService bankService){
        return args -> {
            bankService.consulter();
        };
    };

};
