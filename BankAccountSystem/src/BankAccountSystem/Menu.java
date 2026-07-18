package BankAccountSystem;

import java.util.Scanner;

import BankAccountSystem.feature.account.CreateAccountMenu;
import BankAccountSystem.services.UserAccountService;

public class Menu {


    private UserAccountService userAccountService;
    
    public Menu(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    public void start() {
        // Logic to display menu options and handle user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=================================");
            System.out.println("      BANK ACCOUNT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Account");
            System.out.println("6. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                   new CreateAccountMenu().start(userAccountService, scanner);
                    break;
                case 2:
                    running = false;
                    System.out.println("Exiting the Bank Account System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();

    }

}
