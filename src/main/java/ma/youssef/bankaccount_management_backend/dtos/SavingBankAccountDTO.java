package ma.youssef.bankaccount_management_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class SavingBankAccountDTO extends BankAccountDTO {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private CustomerDTO customerDTO;
    private double interestRate;

}
