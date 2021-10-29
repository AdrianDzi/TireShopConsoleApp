package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO: add Desktop application
        String jdbcURL = "jdbc:mysql://localhost:3306/tireshop";
        String userName = "root";
        String password = "!QAZxsw2";
        int size, width, profile, speedIndex, productYear;
        String mark, model;
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
            Statement myStmt = connection.createStatement();
            System.out.println("connected to DB");
            while (true) {
                System.out.println("type what you want to do: ");
                System.out.println("1 - search tyre");
                System.out.println("2 - add tyre");
                System.out.println("3 - delete tyre");
                System.out.println("4 - show all tires");
                System.out.println("5 - edit tire");
                System.out.println("6 - exit");
                //TODO: add - add/preview/delete invoices
                //TODO: add - sales summary
                Scanner scan = new Scanner(System.in);
                int type;
                while (!scan.hasNextInt()) {
                    System.out.println("wrong input");
                    scan.next();
                }
                type = scan.nextInt();
                if (type < 1 || type > 6) {
                    System.out.println("wrong input");
                } else if (type == 6) {
                    System.out.println("exitting loop");
                    break;
                }
                switch (type) {
                    case 1 -> {
                        SearchTire search = new SearchTire();
                        search.searchTire(jdbcURL, connection, myStmt);
                    }
                    case 2 -> {
                        AddingTire adding = new AddingTire();
                        adding.addingTire(jdbcURL, connection, myStmt);
                    }
                    case 3 -> {
                        RemoveTire removeTire = new RemoveTire();
                        removeTire.removeTire(jdbcURL, connection, myStmt);
                    }
                    case 4 -> {
                        ShowDataFromDB showData = new ShowDataFromDB();
                        showData.showDataFromDB(jdbcURL, connection, myStmt);
                    }
                    case 5 -> {
                        EditTire edit = new EditTire();
                        edit.editTire(jdbcURL, connection, myStmt);
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        }

    }
}
