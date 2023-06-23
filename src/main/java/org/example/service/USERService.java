package org.example.service;

import org.example.DAO.ProductsDAO;
import org.example.DAO.USERDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class USERService {

    public int id;
    public String email;
    public String password;

    public String name;
    public String phone;
    public int role;


    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {this.phone = phone;}
    public void setRole(int role) {
        this.role=role;
    }



    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public int getRole(){
        return role;
    }
    // конструкторы, геттеры и сеттеры

    public static void Menu(USERService user, Scanner STDIN) throws SQLException {
        System.out.println("Hi!\n");
        while (true) {
            System.out.println("What do you wanna do?\n");

            System.out.println("1-View Products\n2-View Orders\n3-Wishlist\n4-View Brands\n5-Exit");

            int choice = STDIN.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Choose a brand to look at:\n");
                    ProductsDAO.viewProducts(STDIN,user);
                    break;
                }
                case 2: {

                    break;
                }
                case 3: {
                 WishlistService.Menu(user,STDIN,0);
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
            }
        }
    }
    }




