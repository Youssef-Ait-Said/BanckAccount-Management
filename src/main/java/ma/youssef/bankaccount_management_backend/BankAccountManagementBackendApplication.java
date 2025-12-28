package ma.youssef.bankaccount_management_backend;

import ma.youssef.bankaccount_management_backend.entities.*;
import ma.youssef.bankaccount_management_backend.enums.AccountStatus;
import ma.youssef.bankaccount_management_backend.enums.OperationType;
import ma.youssef.bankaccount_management_backend.exceptions.BalanceNotSfficientException;
import ma.youssef.bankaccount_management_backend.exceptions.BankAccountNotFoundEcxeption;
import ma.youssef.bankaccount_management_backend.exceptions.CustomerNotFoundEcxeption;
import ma.youssef.bankaccount_management_backend.repositories.AccountOperationRepository;
import ma.youssef.bankaccount_management_backend.repositories.BankAccountRepository;
import ma.youssef.bankaccount_management_backend.repositories.CustomerRepository;
import ma.youssef.bankaccount_management_backend.services.BankAccountService;
import ma.youssef.bankaccount_management_backend.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountManagementBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountManagementBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
        return args -> {
          Stream.of("Hassan", "Youssef" , "Aicha").forEach(name -> {
              Customer customer = new Customer();
              customer.setName(name);
              customer.setEmail(name+"123@gmail.com");
              bankAccountService.saveCustomer(customer);
          });
            for (Customer customer : bankAccountService.listCustomers()) {
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random() * 80000, 9000, customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random() * 120000, 5.5, customer.getId());
                    List<BankAccount> bankAccounts = bankAccountService.bankAccountList();
                    for (BankAccount bankAccount : bankAccounts) {
                        for (int i = 0; i < 10 ; i++) {
                            bankAccountService.credit(bankAccount.getId(), 10000+Math.random()*20000, "Credit");
                            bankAccountService.debit(bankAccount.getId(), 10000+Math.random()*8000, "Debit");

                        }
                    }
                } catch (CustomerNotFoundEcxeption e) {
                    e.printStackTrace();
                } catch (BankAccountNotFoundEcxeption | BalanceNotSfficientException e) {
                    e.printStackTrace();
                }
            }
        };
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
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setType(Math.random()>0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }
            });

        };
    }

};
