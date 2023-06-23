package org.example.service;
import org.example.DAO.WishlistDAO;
import org.example.present.USER;

import static org.example.Utility.utility.connection;

import java.sql.*;
import java.util.Scanner;

public class WishlistService {
    public static void view(USERService user,Scanner STDIN,int for_delete) throws SQLException {
        System.out.println("Your wishlist:\n");
        WishlistDAO.viewWishList(user,STDIN,for_delete);
    }

    public static void Menu(USERService user, Scanner STDIN,int for_delete) throws SQLException {
        System.out.println("What would you like to do?\n1-View wishlist\n2-Delete from wishlist\n3-exit\n");
        int choice=STDIN.nextInt();

        switch (choice){
            case 1:{
                view(user,STDIN,0);
                break;
            }
            case 2:{
                view(user,STDIN,1);
                break;
            }
            case 3:{
                return;
            }
            default:{
                System.out.println("Wrong number.");
                return;
            }
        }
    }

    public static void add(USERService user, int productid) throws SQLException {
        WishlistDAO.add(user,productid);
    }
}
