package ma.youssef.bankaccount_management_backend.dtos;

import lombok.Data;
import ma.youssef.bankaccount_management_backend.entities.AccountOperation;

import java.util.List;

@Data
public class AccountHistoryDTO {
    private String accountId;
    private double balance;
    private int currentPage;
    private  int totalPages;
    private int pageSize;
    private List<AccountOperationDTO> accountOperationDTO;

}
