package org.example.present;

import org.example.DAO.BrandsDAO;
import org.example.service.AdminService;
import org.example.service.USERService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Utility.utility.connection;

public class Admin {
    public static void Menu(USERService user, Scanner STDIN) throws SQLException {
        System.out.println("Hi!\n");

        while (true) {
            System.out.println("What do you wanna do?\n");

            System.out.println("1-Products edit\n2-Brands edit\n3-Exit");

            int choice = STDIN.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1-Add a new product\n2-Delete a product\n3-Exit");
                    choice = STDIN.nextInt();
                    if(choice==1){
                        AdminService.addProduct(STDIN);

                    }else if (choice==2){
                        AdminService.deleteProduct(STDIN);
                    }else{
                        System.out.println("Wrong number!\n");
                    }
                    break;
                }
                case 2: {
                    System.out.println("1-Add a new brand\n2-Delete a brand\n");
                    choice = STDIN.nextInt();
                    if(choice==1){
                        AdminService.addBrand(STDIN);
                    }else if (choice==2){
                        AdminService.deleteBrand(STDIN);
                    }else{
                        System.out.println("Wrong number!\n");
                    }
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }

            }
        }

    }
}
