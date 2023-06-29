package org.example.AllOpr;

import org.example.AllOpr.AddNewBook;
import org.example.AllOpr.DeleteBook;
import org.example.AllOpr.ReadAllBookList;
import org.example.AllOpr.UpdateBook;

import java.util.Scanner;

public class Operations {
    public static void opr() {
        Scanner scanner = new Scanner(System.in);
        boolean state = true;
        while (state) {
            System.out.println("What operation do you want to do? ");
            System.out.println("");
            System.out.println("Add New Book - 1");
            System.out.println("Delete Book - 2");
            System.out.println("Update Books' Informations - 3");
            System.out.println("Show All Books - 4");
            System.out.println("Stop All Operations - 0");
            int chosing = scanner.nextInt();
            if (chosing == 1) {
                AddNewBook.addBook();
            } else if (chosing == 2) {
                DeleteBook.deleteBook();
            } else if (chosing == 3) {
                UpdateBook.updateBook();
            } else if (chosing == 4) {
                ReadAllBookList.allBookList();
            } else if (chosing == 0) {
                state = false;
            }
        }
    }
}
