package BankAccountSystem;

public class BankService {

    public void createAccount(String firstName, String middleName, String lastName, double initialDeposit) {
        // Logic to create a new bank account
        String accountHolderInfo = firstName + " " + (middleName != null ? middleName + " " : "") + lastName;

        System.out.println("Account created for: " + accountHolderInfo + " with initial deposit of Php" + initialDeposit);

    }
}
