package org.example.AllOpr;

import org.example.DBConnect.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UpdateBook {
    private static Connection connection = DbConnection.getInstance().getConnection();

    public static void updateBook() {
        boolean state = true;
        while (state) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("To continue press 1 / Back to the main menu press 0");
            int proses = scanner.nextInt();
            if (proses == 1) {

                try {
                    ReadAllBookList.allBookList();
                    System.out.println("Enter the ID of the book you want to update");
                    int bookUpdateId = scanner.nextInt();
                    System.out.println("Is this the book you want to update? Yes/No");
                    System.out.println(ReadAllBookList.getBookList().stream().filter(book -> book.getId() == bookUpdateId).collect(Collectors.toList()));
                    String yesNo = scanner.next();
                    if (yesNo.equalsIgnoreCase("yes")) {
                        System.out.println("Select the cell you want to update");
                        System.out.println("For New ID - 1");
                        System.out.println("For New Author - 2");
                        System.out.println("For New Book - 3 ");
                        System.out.println("For New Price - 4");
                        System.out.println("For New Quantity - 5");
                        System.out.println("For All Cells - 6");
                        System.out.println("Stop to Update Operation press - 0 ");
                        int chooseColumn = scanner.nextInt();
                        if (chooseColumn == 1) {
                            String updateQuery = "update list_of_book set id = ? where id =?";
                            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                            System.out.println("Enter New ID");
                            int newId = scanner.nextInt();
                            preparedStatement.setInt(1, newId);
                            preparedStatement.setInt(2, bookUpdateId);
                            preparedStatement.executeUpdate();
                        } else if (chooseColumn == 2) {
                            String updateQuery = "update list_of_book set author = ? where id =?";
                            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                            System.out.println("Enter New Author");
                            String newAuthorTest = scanner.nextLine();
                            String newAuthor = scanner.nextLine();
                            preparedStatement.setString(1, newAuthor);
                            preparedStatement.setInt(2, bookUpdateId);
                            preparedStatement.executeUpdate();
                        } else if (chooseColumn == 3) {

                            System.out.println("Enter New Book Name");
                            String newTitleTest = scanner.nextLine();
                            String newTitle = scanner.nextLine();
                            String updateQuery = "update list_of_book set title = ? where id =?";
                            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                            preparedStatement.setString(1, newTitle);
                            preparedStatement.setInt(2, bookUpdateId);
                            preparedStatement.executeUpdate();
                        } else if (chooseColumn == 4) {
                            String updateQuery = "update list_of_book set price = ? where id =?";
                            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                            System.out.println("Enter New Price");
                            double newPrice = scanner.nextDouble();
                            preparedStatement.setDouble(1, newPrice);
                            preparedStatement.setInt(2, bookUpdateId);
                            preparedStatement.executeUpdate();
                        } else if (chooseColumn == 5) {
                            String updateQuery = "update list_of_book set quantity = ? where id =?";
                            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                            System.out.println("Enter New Quantity");
                            int newQuantity = scanner.nextInt();
                            preparedStatement.setInt(1, newQuantity);
                            preparedStatement.setInt(2, bookUpdateId);
                            preparedStatement.executeUpdate();
                        } else if (chooseColumn == 6) {
                            String updateQuery = "update list_of_book set id =?, author=?, title=?, price =?, quantity=? where id =?";
                            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                            System.out.println("Enter New ID");
                            int newId = scanner.nextInt();
                            System.out.println("Enter New Author");
                            String newTest = scanner.nextLine();
                            String newAuthor = scanner.nextLine();
                            System.out.println("Enter New Book Name");
                            String newBookName = scanner.nextLine();
                            System.out.println("Enter New Price");
                            double newPrice = scanner.nextDouble();
                            System.out.println("Enter New Quantity");
                            int newQuantity = scanner.nextInt();
                            preparedStatement.setInt(1, newId);
                            preparedStatement.setString(1, newAuthor);
                            preparedStatement.setString(1, newBookName);
                            preparedStatement.setDouble(1, newPrice);
                            preparedStatement.setInt(1, newQuantity);
                            preparedStatement.setInt(2, bookUpdateId);
                            preparedStatement.executeUpdate();
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (proses == 0) {
                state = false;
            }
        }

    }
}