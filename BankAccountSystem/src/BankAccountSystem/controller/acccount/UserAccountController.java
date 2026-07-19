package BankAccountSystem.controller.acccount;

import BankAccountSystem.services.UserAccountService;

public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    public UserAccountService getUserAccountService() {
        return userAccountService;
    }

    public void createAccount(String firstName, String middleName, String lastName, double initialDeposit, String email, String password) {
        userAccountService.createUserAccount(firstName, middleName, lastName, initialDeposit, email, password);
    }
}
