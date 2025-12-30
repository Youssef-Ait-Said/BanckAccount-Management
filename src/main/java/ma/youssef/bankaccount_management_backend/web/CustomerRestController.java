package ma.youssef.bankaccount_management_backend.web;

import lombok.AllArgsConstructor;
import ma.youssef.bankaccount_management_backend.dtos.CustomerDTO;
import ma.youssef.bankaccount_management_backend.entities.Customer;
import ma.youssef.bankaccount_management_backend.exceptions.CustomerNotFoundEcxeption;
import ma.youssef.bankaccount_management_backend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {

    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }

    @GetMapping("customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundEcxeption {
        return bankAccountService.getCustomerDTO(customerId);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) throws CustomerNotFoundEcxeption {
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) throws CustomerNotFoundEcxeption {
        customerDTO.setId( customerId );
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundEcxeption {
        bankAccountService.deleteCustomer(customerId);
    }





}
