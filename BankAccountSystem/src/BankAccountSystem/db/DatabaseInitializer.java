package BankAccountSystem.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {
    
    public static void initializeDatabase(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            // Create the accounts table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                                    "uuid UUID PRIMARY KEY," +
                                    "first_name VARCHAR(50) NOT NULL," +
                                    "middle_name VARCHAR(50)," +
                                    "last_name VARCHAR(50) NOT NULL," +
                                    "balance DECIMAL(15, 2) NOT NULL," +
                                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                                    "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                                    ")";
            statement.executeUpdate(createTableSQL);
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }
}
