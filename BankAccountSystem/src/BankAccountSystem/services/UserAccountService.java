package BankAccountSystem.services;

import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
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

    public void createUserAccount(String firstName, String middleName, String lastName, double initialDeposit, String email, String password) {
        
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        UserAccount userAccount = new UserAccount( UUID.randomUUID(), firstName, middleName, lastName, email, hashedPassword, initialDeposit);

        repository.save(userAccount);
    }

    public void updateUserAccount(UserAccount userAccount) {
        repository.update(userAccount);
    }

    public void deleteUserAccount(String uuid) {
        repository.delete(uuid);
    }
}
