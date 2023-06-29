package org.example.AllOpr;

import org.example.DBConnect.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadAllBookList {
    private static Connection connection = DbConnection.getInstance().getConnection();
    private static List<Book> list;

    public static void allBookList() {
        list = new ArrayList<>();
        try {
            String allBookQuery = "select * from list_of_book";
            PreparedStatement preparedStatement = connection.prepareStatement(allBookQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String author = resultSet.getString("author");
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                list.add(new Book(id, author, title, price, quantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        list.forEach(book -> System.out.println(book));
    }
    public static List<Book> getBookList() {
        list = new ArrayList<>();
        try {
            String allBookQuery = "select * from list_of_book";
            PreparedStatement preparedStatement = connection.prepareStatement(allBookQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String author = resultSet.getString("author");
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                list.add(new Book(id, author, title, price, quantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       return list;
    }
}
