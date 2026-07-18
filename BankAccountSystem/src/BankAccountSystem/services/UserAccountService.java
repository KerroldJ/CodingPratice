package BankAccountSystem.services;

import java.util.UUID;

import BankAccountSystem.model.UserAccount;
import BankAccountSystem.repository.UserAccountRepository;

public class UserAccountService {
    
    private UserAccountRepository repository;

    public UserAccountService(UserAccountRepository repository) {
        this.repository = repository;
    }

    public UserAccount getUserAccountById(String uuid) {
        return repository.findById(uuid);
    }

    public void createUserAccount(String firstName, String middleName, String lastName, double initialDeposit) {
        
        UserAccount userAccount = new UserAccount( UUID.randomUUID(), firstName, middleName, lastName, initialDeposit);
        repository.save(userAccount);
        System.out.println("User account created for: " + firstName + " " + (middleName != null ? middleName + " " : "") + lastName + " with initial deposit of Php" + initialDeposit);
    }

    public void updateUserAccount(UserAccount userAccount) {
        repository.update(userAccount);
    }

    public void deleteUserAccount(String uuid) {
        repository.delete(uuid);
    }
}
