package ma.youssef.bankaccount_management_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Getter @Setter

public class Customer {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<BankAccount> bankAccounts;
}
