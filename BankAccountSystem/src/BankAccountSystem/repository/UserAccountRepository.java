package BankAccountSystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BankAccountSystem.db.DatabaseConnection;
import BankAccountSystem.model.UserAccount;

public class UserAccountRepository {

    public void save(UserAccount userAccount) {

        String sql = """
                    INSERT INTO accounts
                    (uuid, first_name, middle_name, last_name, balance)
                    VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, userAccount.getUuid());
            statement.setString(2, userAccount.getFirstName());
            statement.setString(3, userAccount.getMiddleName());
            statement.setString(4, userAccount.getLastName());
            statement.setDouble(5, userAccount.getBalance());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Account saved successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public UserAccount findById(String uuid) {
        String sql = "SELECT * FROM accounts WHERE uuid = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, uuid);

            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new UserAccount(
                        (java.util.UUID) resultSet.getObject("uuid"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDouble("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(UserAccount userAccount) {
        String sql = """
                    UPDATE accounts
                    SET first_name = ?, middle_name = ?, last_name = ?, balance = ?
                    WHERE uuid = ?
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, userAccount.getFirstName());
            statement.setString(2, userAccount.getMiddleName());
            statement.setString(3, userAccount.getLastName());
            statement.setDouble(4, userAccount.getBalance());
            statement.setObject(5, userAccount.getUuid());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Account updated successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String uuid) {
        String sql = "DELETE FROM accounts WHERE uuid = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, uuid);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Account deleted successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}