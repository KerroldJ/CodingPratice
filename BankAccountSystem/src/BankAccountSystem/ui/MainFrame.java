package BankAccountSystem.ui;

import javax.swing.JFrame;

import BankAccountSystem.controller.acccount.UserAccountController;
// import BankAccountSystem.services.UserAccountService;
import BankAccountSystem.ui.account.CreateAccountPanel;

public class MainFrame extends JFrame {

    private final UserAccountController userAccountController;

    public UserAccountController getUserAccountController() {
        return userAccountController;
    }
    
    public MainFrame(UserAccountController userAccountController) {
        this.userAccountController = userAccountController;
        setTitle("Bank Account System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new CreateAccountPanel(userAccountController));

        setVisible(true);
    }

}
