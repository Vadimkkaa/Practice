package org.example.DAO;
import org.example.present.Brands;
import org.example.present.Products;
import org.example.service.USERService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Utility.utility.connection;

public interface USERDAO {

    public static USERService findUserByEmailAndPassword(String email, String password, Connection connection) throws SQLException {
        String sql = "SELECT * FROM public.\"USER\" WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            USERService user = new USERService();
            user.setId(resultSet.getInt("userid"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            user.setPhone(resultSet.getString("phone"));
            user.setRole(resultSet.getInt("role"));
            return user;
        } else {
            return null;
        }
    }


}
