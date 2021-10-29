package com.company;

import java.sql.*;
import java.util.Scanner;

public class RemoveTire {
    int size, width, profile, speedIndex, productYear;
    String mark, model;

    public void removeTire(String jdbcURL, Connection connection, Statement myStmt) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Data from DB:");
        String showData = "select * from tireshop.tire";
        ResultSet rsData = myStmt.executeQuery(showData);

        while (rsData.next()) {
            String key = rsData.getString("id");
            String size = rsData.getString("size");
            String width = rsData.getString("width");
            String profile = rsData.getString("profile");
            String speedIndex = rsData.getString("speedIndex");
            String productYear = rsData.getString("productYear");
            String mark = rsData.getString("mark");
            String model = rsData.getString("model");
            System.out.println("id: " + key + " size: " + size + " width: " + width + " profile: " + profile + " speed index: " + speedIndex + " product year: " + productYear + " mark: " + mark + " model: " + model);
        }
        System.out.println("type id which tire you want to delete: ");
        String keyToDelete = scan.next();
        String deletingPerson = "delete from tireshop.tire where id=" + keyToDelete;

        myStmt.executeUpdate(deletingPerson);
        System.out.println("tire remooved");
    }
}

