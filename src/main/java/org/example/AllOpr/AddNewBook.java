package org.example.AllOpr;

import org.example.DBConnect.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddNewBook {
    private static Connection connection = DbConnection.getInstance().getConnection();

    public static void addBook() {
        boolean state = true;
        while (state) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("To continue press 1 / Back to the main menu press 0");
            int proses = scanner.nextInt();
            if (proses == 1) {
                try {
                    PreparedStatement preparedStatement = null;

                    String query = "insert into list_of_book(id,author,title,price,quantity) values(?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(query);
                    System.out.println("Enter the ID ");
                    int id = scanner.nextInt();
                    String test = scanner.nextLine();
                    preparedStatement.setInt(1, id);
                    System.out.println("Enter the Author");
                    String author = scanner.nextLine();
                    preparedStatement.setString(2, author);
                    System.out.println("Enter the Book Name");
                    String title = scanner.nextLine();
                    preparedStatement.setString(3, title);
                    System.out.println("Price: ");
                    double price = scanner.nextDouble();
                    preparedStatement.setDouble(4, price);
                    System.out.println("Quantity: ");
                    int quantity = scanner.nextInt();
                    preparedStatement.setInt(5, quantity);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (proses == 0) {
                state = false;
            }
        }
    }
}
