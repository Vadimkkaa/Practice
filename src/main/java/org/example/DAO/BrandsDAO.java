package org.example.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Utility.utility.connection;

public interface BrandsDAO {
    public static void addBrand(Scanner STDIN) throws SQLException {
        PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO public.\"Brands\" (name, description) values (?,?)");
        System.out.print("Enter brand's name:\n");
        STDIN.nextLine();
        String name = STDIN.nextLine();
        System.out.print("Enter brand's description:\n");
        String description = STDIN.nextLine();

        System.out.println("Name: "+name+"\nDescription: "+description);

        prepStatement.setString(1, name);
        prepStatement.setString(2, description);
        prepStatement.executeUpdate();
    }
    public static void deleteBrand(Scanner STDIN) throws SQLException {
        System.out.println("Enter brand's id:\n");
        int DelID = STDIN.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.\"Brands\" WHERE brandid = ?");
        preparedStatement.setInt(1, DelID);
        preparedStatement.executeUpdate();
    }
}
