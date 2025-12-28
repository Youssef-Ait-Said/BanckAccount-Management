package ma.youssef.bankaccount_management_backend.services;

import ma.youssef.bankaccount_management_backend.entities.BankAccount;
import ma.youssef.bankaccount_management_backend.entities.CurrentAccount;
import ma.youssef.bankaccount_management_backend.entities.Customer;
import ma.youssef.bankaccount_management_backend.entities.SavingAccount;
import ma.youssef.bankaccount_management_backend.exceptions.BalanceNotSfficientException;
import ma.youssef.bankaccount_management_backend.exceptions.BankAccountNotFoundEcxeption;
import ma.youssef.bankaccount_management_backend.exceptions.CustomerNotFoundEcxeption;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundEcxeption;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundEcxeption;
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundEcxeption;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundEcxeption, BalanceNotSfficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundEcxeption;
    void transfer(String accountIdSource, String accountIdDest, double amount) throws BalanceNotSfficientException, BankAccountNotFoundEcxeption;


    List<BankAccount> bankAccountList();
}
