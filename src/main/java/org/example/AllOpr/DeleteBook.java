package org.example.AllOpr;

import org.example.DBConnect.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {
    private static Connection connection = DbConnection.getInstance().getConnection();

    public static void deleteBook() {
        boolean state = true;
        while (state) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("To continue press 1 / Back to the main menu press 0");
            int proses = scanner.nextInt();
            if (proses == 1) {
                try {

                    String deleteQuery = "delete from list_of_book where id=? ";
                    PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                    ReadAllBookList.allBookList();
                    System.out.println("Enter the ID of the book you want to delete");
                    int deleteId = scanner.nextInt();
                    preparedStatement.setInt(1, deleteId);
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
