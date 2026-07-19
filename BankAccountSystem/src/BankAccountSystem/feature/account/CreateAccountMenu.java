package BankAccountSystem.feature.account;

import java.util.Scanner;

import BankAccountSystem.services.UserAccountService;

public class CreateAccountMenu {

    public void start(UserAccountService userAccountService, Scanner scanner) {
        System.out.println("=== Create Account Menu ===");
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Middle Name (optional): ");
        String middleName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter Initial Deposit Amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        userAccountService.createUserAccount(firstName, middleName, lastName, initialDeposit, email, password);
    }
}
