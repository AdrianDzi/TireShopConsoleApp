package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddingTire {
    int size, width, profile, speedIndex, productYear;
    String mark, model;
    public void addingTire(String jdbcURL, Connection connection, Statement myStmt) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("type size: ");
        size = scan.nextInt();
        System.out.println("type width: ");
        width = scan.nextInt();
        System.out.println("type profile: ");
        profile = scan.nextInt();
        System.out.println("type product year: ");
        productYear = scan.nextInt();
        System.out.println("type speed index: ");
        speedIndex = scan.nextInt();
        System.out.println("type mark: ");
        mark = scan.next();
        System.out.println("type model: ");
        model = scan.next();

        String addingPerson = "insert into tireshop.tire (size, width, profile, speedIndex, productYear, mark, model) values(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(addingPerson);
        ps.setInt(1, size);
        ps.setInt(2, width);
        ps.setInt(3, profile);
        ps.setInt(4, speedIndex);
        ps.setInt(5, productYear);
        ps.setString(6, mark);
        ps.setString(7, model);
        ps.executeUpdate();
        System.out.println("tire added with parameters:" +
                "size: " + size +
                "width: " + width +
                "profile: " + profile +
                "speed index: " + speedIndex +
                "product year: " + productYear +
                "mark: " + mark +
                "model: " + model + ", thanks!");
    }
}
