package BankAccountSystem;

import java.util.Scanner;

public class Menu {

    private BankService bankService;

    public Menu(BankService bankService) {
        this.bankService = bankService;
    }

    public void start() {
        // Logic to display menu options and handle user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Bank Account System!");
            System.out.println("1. Create Account");
            System.out.println("2. Exit");
            System.out.print("Please select an option: ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Middle Name (or press Enter to skip): ");
                    String middleName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Initial Deposit Amount: ");
                    double initialDeposit = scanner.nextDouble();

                    scanner.nextLine(); // Consume the newline character
                    bankService.createAccount(
                        firstName,
                        middleName != null && !middleName.isEmpty() ? middleName : null,
                        lastName,
                        initialDeposit
                    );
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
