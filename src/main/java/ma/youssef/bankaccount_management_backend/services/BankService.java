package ma.youssef.bankaccount_management_backend.services;

import jakarta.transaction.Transactional;
import ma.youssef.bankaccount_management_backend.entities.BankAccount;
import ma.youssef.bankaccount_management_backend.entities.CurrentAccount;
import ma.youssef.bankaccount_management_backend.entities.SavingAccount;
import ma.youssef.bankaccount_management_backend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter() {
        BankAccount bankAccount = bankAccountRepository.findById("0b875f1b-1478-4e2d-8012-2e651c059741").orElse(null);
        System.out.println("===============================");
        System.out.println(bankAccount.getId());
        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount.getCreatedAt());
        System.out.println(bankAccount.getStatus());
        System.out.println(bankAccount.getCustomer().getName());
        System.out.println(bankAccount.getClass().getSimpleName());

        if (bankAccount instanceof SavingAccount) {
            System.out.println("Rate => " + ((SavingAccount) bankAccount).getInterestRate());
        } else if (bankAccount instanceof CurrentAccount) {
            System.out.println("Over Draft => " + ((CurrentAccount) bankAccount).getOverdraft());
        }
        System.out.println("************************************");

        bankAccount.getAccountOperations().forEach(op -> {
            System.out.println(op.getType() + "\t" + op.getAmount() + "\t" + op.getDate());
        });
    };
}