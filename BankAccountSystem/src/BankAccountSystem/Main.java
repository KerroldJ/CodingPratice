package BankAccountSystem;

public class Main {
   public static void main(String[] args) {
    
    BankService bankService = new BankService();

    Menu menu = new Menu(bankService);

    menu.start(); // This is to start the menu and allow user interaction with the banking system.

   } 
}
