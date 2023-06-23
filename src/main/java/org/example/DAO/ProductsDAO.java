package org.example.DAO;

import org.example.present.Brands;
import org.example.present.Products;
import org.example.service.USERService;
import org.example.service.WishlistService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Utility.utility.connection;

public interface ProductsDAO {
    public static void addProduct(Scanner STDIN) throws SQLException {
        PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO public.\"Products\" (brandid, name,description,price,color,image) values (?,?,?,?,?,?)");
        System.out.print("Enter products's brandid:\n");
        int brand = STDIN.nextInt();

        System.out.print("Enter products's name:\n");
        STDIN.nextLine();
        String name = STDIN.nextLine();

        System.out.print("Enter product's description:\n");
        String description = STDIN.nextLine();

        System.out.print("Enter products's price:\n");
        int price = STDIN.nextInt();

        System.out.print("Enter products's color:\n");
        STDIN.nextLine();
        String color = STDIN.nextLine();

        System.out.print("Enter products's image link:\n");
        String image = STDIN.nextLine();


        prepStatement.setInt(1, brand);
        prepStatement.setString(2, name);
        prepStatement.setString(3, description);
        prepStatement.setInt(4, price);
        prepStatement.setString(5, color);
        prepStatement.setString(6, image);
        prepStatement.executeUpdate();
    }
    public static void deleteProduct(Scanner STDIN) throws SQLException {
        int DelID = STDIN.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.\"Products\" WHERE productid = ?");
        preparedStatement.setInt(1, DelID);
        preparedStatement.executeUpdate();
    }

    public static void viewProducts(Scanner STDIN, USERService user) throws SQLException{
        List<Brands> brands = new ArrayList<>();
        List<Products> products = new ArrayList<>();

        int orderbrands=1;
        int orderproducts=1;
        int choice;

        //brands
        PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM public.\"Brands\"");
        ResultSet resultSet = prepStatement.executeQuery();
        //products

        while(resultSet.next()){
            System.out.println(orderbrands+":"+resultSet.getString("name")+"\n");

            Brands brand = new Brands(
                    resultSet.getInt("brandid"),
                    resultSet.getString("name"),
                    resultSet.getString("description")
            );

            brands.add(brand);
            orderbrands++;
        }
        System.out.println("Pick the one you like:\n");
        choice=STDIN.nextInt();

        if(choice<1 || choice>brands.size()){
            while(choice<1 || choice>brands.size()){
                System.out.println("You entered the wrong number, try again\n");
                choice=STDIN.nextInt();
            }
        }

        //Brands brand_chosen=brands.get(choice-1);

        Brands brand_chosen=new Brands(
                brands.get(choice-1).brandid,
                brands.get(choice-1).name,
                brands.get(choice-1).description
        );

        //  int brandidchosen=brand_chosen.brandid;

        PreparedStatement prepStatement1 = connection.prepareStatement("SELECT * FROM public.\"Products\"");
        ResultSet resultSet1 = prepStatement1.executeQuery();

        boolean flag=false;

        while(resultSet1.next()){
            if(resultSet1.getInt("brandid")==brand_chosen.brandid){
                flag=true;
                Products product=new Products(
                        resultSet1.getInt("productid"),
                        resultSet1.getInt("brandid"),
                        resultSet1.getString("name"),
                        resultSet1.getString("description"),
                        resultSet1.getInt("price"),
                        resultSet1.getString("color"),
                        resultSet1.getString("image")
                );
                products.add(product);
            }
        }


        if(flag==false){
            System.out.println("Sorry.but we don't have products of that brand yet\n");
            return;
        }else{
            System.out.println("Available products:\n");
            for(int i=0;i<products.size();i++,orderproducts++){

                System.out.println(orderproducts + ":\n");
                System.out.println("Car name is: " + products.get(orderproducts - 1).name + "\n");
                System.out.println("Car description is: " + products.get(orderproducts - 1).description + "\n");
                System.out.println("Car price is: " + products.get(orderproducts - 1).price + "\n");
                System.out.println("Car color is: " + products.get(orderproducts - 1).color + "\n");
                System.out.println("Car image link is: " + products.get(orderproducts - 1).image + "\n");
                System.out.println("\n");
            }

        }

        System.out.println("Would you like to buy some of these products?\n1-Yes\n2-No");

        choice=STDIN.nextInt();

        switch (choice){
            case 1:{
///////////////////
                break;
            }
            case 2:{
                System.out.println("Ok");
                return;
            }
            default:{
                System.out.println("The wrong number is entered");
                return;
            }
        }

        System.out.println("Would you like to add some of these products to wishlist?\n1-Yes\n2-No");

        choice=STDIN.nextInt();
        orderproducts=1;

        switch (choice){
            case 1:{
                System.out.println("Which one would you like to add?\n");

                for(int i=0;i<products.size();i++,orderproducts++){

                    System.out.println(orderproducts + ":\n");
                    System.out.println("Car name is: " + products.get(orderproducts - 1).name + "\n");
                    System.out.println("Car description is: " + products.get(orderproducts - 1).description + "\n");
                    System.out.println("Car price is: " + products.get(orderproducts - 1).price + "\n");
                    System.out.println("Car color is: " + products.get(orderproducts - 1).color + "\n");
                    System.out.println("Car image link is: " + products.get(orderproducts - 1).image + "\n");
                    System.out.println("\n");
                }

                choice=STDIN.nextInt();

                if(choice<1 || choice>products.size()){
                    while(choice<1 || choice>products.size()){
                        System.out.println("You entered the wrong number, try again\n");
                        choice=STDIN.nextInt();
                    }
                }

                WishlistService.add(user,products.get(choice-1).productid );

                break;
            }
            case 2:{
                System.out.println("Ok");
                return;
            }
            default:{
                System.out.println("The wrong number is entered");
                return;
            }
        }
    }
}
