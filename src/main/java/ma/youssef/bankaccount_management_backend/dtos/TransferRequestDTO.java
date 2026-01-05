package ma.youssef.bankaccount_management_backend.dtos;

import lombok.Data;

@Data
public class TransferRequestDTO {
    public String accountSource;
    public String accountDestination;
    public double amount;
    public String description;
}
