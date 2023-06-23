package org.example.service;
import org.example.DAO.BrandsDAO;
import org.example.DAO.ProductsDAO;

import static org.example.Utility.utility.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminService {
public static void addBrand(Scanner STDIN) throws SQLException{
    BrandsDAO.addBrand(STDIN);

}
    public static void deleteBrand(Scanner STDIN) throws SQLException{
        BrandsDAO.deleteBrand(STDIN);

    }
    public static void addProduct(Scanner STDIN) throws SQLException{
        ProductsDAO.addProduct(STDIN);

    }
    public static void deleteProduct(Scanner STDIN) throws SQLException{
        ProductsDAO.deleteProduct(STDIN);

    }

}


