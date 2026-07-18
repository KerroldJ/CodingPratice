package BankAccountSystem;

import BankAccountSystem.db.DatabaseConnection;
import BankAccountSystem.db.DatabaseInitializer;
import BankAccountSystem.repository.UserAccountRepository;
import BankAccountSystem.services.UserAccountService;

public class Main {
   public static void main(String[] args) {

      DatabaseInitializer.initializeDatabase(DatabaseConnection.getConnection());

      // Inject the Application Service into the Menu
      UserAccountRepository repository = new UserAccountRepository();
      UserAccountService userAccountService = new UserAccountService(repository);

      Menu menu = new Menu(userAccountService);

      menu.start();

   }
}