package ma.youssef.bankaccount_management_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SavingAccount extends BankAccount{
    private double InterestRate;
}
