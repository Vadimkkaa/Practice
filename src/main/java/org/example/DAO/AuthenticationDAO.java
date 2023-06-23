package org.example.DAO;

//import org.example.DAO.USERDAO;

//import org.example.service.USERService;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;


import static org.example.Utility.utility.connection;

public interface AuthenticationDAO {

    public static void Registration(String name, String mail, String phone, String address, int role, String password) throws SQLException {

        PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO public.\"USER\" (name, email, phone,address,role,password) values (?,?,?,?,?,?)");
        prepStatement.setString(1, name);
        prepStatement.setString(2, mail);
        prepStatement.setString(3, phone);
        prepStatement.setString(4, address);
        prepStatement.setInt(5, 1);
        prepStatement.setString(6, password);
        prepStatement.executeUpdate();
    }

    public static int Check_mail(String mail) throws SQLException{
        PreparedStatement prepStatement = connection.prepareStatement("SELECT email  FROM public.\"USER\"");
        ResultSet resultSet = prepStatement.executeQuery();
        while(resultSet.next()){
            String email = resultSet.getString("email");
            if(email.equals(mail)){
                System.out.println("I am sorry, but this email is taken. Choose another one\n");
                return 0;
            }

        }
        return 1;
    }

}
