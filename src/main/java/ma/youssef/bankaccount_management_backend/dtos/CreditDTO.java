package ma.youssef.bankaccount_management_backend.dtos;

import lombok.Data;

@Data
public class CreditDTO {
    public String accountId;
    public double amount;
    public String description;
}
