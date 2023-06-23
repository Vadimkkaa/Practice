package org.example.DAO;

import org.example.present.USER;
import org.example.service.USERService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Utility.utility.connection;

public interface WishlistDAO {

    public static void viewWishList(USERService user, Scanner STDIN , int for_delete) throws SQLException {
        int order = 1;

        PreparedStatement prepStatement1 = connection.prepareStatement("SELECT COUNT(wishlistid) FROM \"Wishlist\"");
        ResultSet resultSet1 = prepStatement1.executeQuery();

        PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM \"Wishlist\"");
        ResultSet resultSet = prepStatement.executeQuery();

        if (resultSet1.next()) {
            if (resultSet1.getInt("count") == 0) {
                System.out.println("No items in wishlist");
            }

        }

        if (for_delete == 0) {
            System.out.println("Products you liked:\n");

            while (resultSet.next()) {
                System.out.println(order + ":\n");



                order++;
            }
        }else{


        }
    }

    public static void add(USERService user, int productid) throws SQLException{
        PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO public.\"Wishlist\" (userid,productid) values (?,?)");

        prepStatement.setInt(1, user.id);
        prepStatement.setInt(2, productid);
        prepStatement.executeUpdate();
    }
}
