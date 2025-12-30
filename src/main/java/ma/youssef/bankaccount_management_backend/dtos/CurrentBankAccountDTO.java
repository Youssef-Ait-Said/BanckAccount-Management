package ma.youssef.bankaccount_management_backend.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CurrentBankAccountDTO extends BankAccountDTO {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private CustomerDTO customerDTO;
    private double overdraft;

}
