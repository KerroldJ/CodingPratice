package BankAccountSystem.ui.account;

import BankAccountSystem.controller.acccount.UserAccountController;

import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;

public class CreateAccountPanel extends javax.swing.JPanel {

    private final UserAccountController userAccountController;

    public UserAccountController getUserAccountController() {
        return userAccountController;
    }

    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameField;

    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JTextField middleNameField;

    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameField;

    private javax.swing.JLabel initialDepositLabel;
    private javax.swing.JTextField initialDepositField;

    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailField;

    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordField;

    private javax.swing.JButton createAccountButton;

    public CreateAccountPanel(UserAccountController userAccountController) {
        this.userAccountController = userAccountController;
        initializeComponents();
        registerEvents();
    }

    private void addComponents(Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(component, gbc);

    }

    public void initializeComponents() {

        setLayout(new GridBagLayout());

        firstNameLabel = new javax.swing.JLabel("First Name:");
        addComponents(firstNameLabel, 0, 0);

        firstNameField = new javax.swing.JTextField(20);
        addComponents(firstNameField, 1, 0);

        middleNameLabel = new javax.swing.JLabel("Middle Name:");
        addComponents(middleNameLabel, 0, 1);

        middleNameField = new javax.swing.JTextField(20);
        addComponents(middleNameField, 1, 1);

        lastNameLabel = new javax.swing.JLabel("Last Name:");
        addComponents(lastNameLabel, 0, 2);

        lastNameField = new javax.swing.JTextField(20);
        addComponents(lastNameField, 1, 2);

        initialDepositLabel = new javax.swing.JLabel("Initial Deposit:");
        addComponents(initialDepositLabel, 0, 3);

        initialDepositField = new javax.swing.JTextField(20);
        addComponents(initialDepositField, 1, 3);

        emailLabel = new javax.swing.JLabel("Email:");
        addComponents(emailLabel, 0, 4);

        emailField = new javax.swing.JTextField(20);
        addComponents(emailField, 1, 4);

        passwordLabel = new javax.swing.JLabel("Password:");
        addComponents(passwordLabel, 0, 5);

        passwordField = new javax.swing.JPasswordField(20);
        addComponents(passwordField, 1, 5);

        createAccountButton = new javax.swing.JButton("Create Account");
        addComponents(createAccountButton, 0, 6);
    }

    public void registerEvents() {

        createAccountButton.addActionListener(e -> {

            try {

                String firstName = firstNameField.getText();
                String middleName = middleNameField.getText();
                String lastName = lastNameField.getText();
                double initialDeposit = Double.parseDouble(initialDepositField.getText());
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                userAccountController.createAccount(
                        firstName,
                        middleName,
                        lastName,
                        initialDeposit,
                        email, 
                        password);

                JOptionPane.showMessageDialog(
                        this,
                        "Account saved successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                clearForm();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            }

        });

    }


    private void clearForm() {
        firstNameField.setText("");
        middleNameField.setText("");
        lastNameField.setText("");
        initialDepositField.setText("");
        emailField.setText("");
        passwordField.setText("");

        firstNameField.requestFocusInWindow();
    }

}
