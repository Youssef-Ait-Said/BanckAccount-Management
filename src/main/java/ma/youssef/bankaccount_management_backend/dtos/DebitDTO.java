package ma.youssef.bankaccount_management_backend.dtos;

import lombok.Data;

@Data
public class DebitDTO {
    public String accountId;
    public double amount;
    public String description;
}
