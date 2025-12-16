package ma.youssef.bankaccount_management_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youssef.bankaccount_management_backend.enums.OperationType;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class AccountOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double amount;
    private OperationType type;
    @ManyToOne()
    private BankAccount bankAccount;
}
