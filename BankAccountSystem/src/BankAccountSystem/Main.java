package BankAccountSystem;

import BankAccountSystem.controller.acccount.UserAccountController;
import BankAccountSystem.db.DatabaseConnection;
import BankAccountSystem.db.DatabaseInitializer;
import BankAccountSystem.repository.UserAccountRepository;
import BankAccountSystem.services.UserAccountService;
import BankAccountSystem.ui.MainFrame;

public class Main {
   public static void main(String[] args) {

      DatabaseInitializer.initializeDatabase(DatabaseConnection.getConnection());

      // Inject the Application Service into the Menu
      UserAccountRepository repository = new UserAccountRepository();
      UserAccountService userAccountService = new UserAccountService(repository);

      // Inject the Application Service into the Controller
      UserAccountController controller = new UserAccountController(userAccountService);

      new MainFrame(controller);

   }
}