package org.example.service;


import org.example.DAO.AuthenticationDAO;
import org.example.DAO.USERDAO;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Utility.utility.connection;

public class AuthenticationService {

      public static void Registration(String name, String mail, String phone, String address, int role, String password) throws SQLException {
        AuthenticationDAO.Registration(name,mail,phone,address,1,password);
      }
      public static USERService Login(Scanner STDIN) throws SQLException {
          int role;

          System.out.println("Enter your email:\n");

          //STDIN.nextLine();
          String mail = STDIN.next();

          System.out.println("Now enter your password:\n");

          STDIN.nextLine();
          String password = STDIN.nextLine();

          System.out.println("mail: "+ mail +"  password: "+password+"\n");

          USERService user;

          try {
              user =  USERDAO.findUserByEmailAndPassword(mail,password,connection);
          } catch (SQLException e) {
              throw new RuntimeException("Unable to find user", e);
          }

          if (user != null) {
              if(user.getRole()==1){
                  role=1;
                  System.out.println("Welcome User!\nYour ID is: "+user.getID()+"\nYour Phone is: "+user.getPhone());

              }else if(user.getRole()==0){
                  role=0;
                  System.out.println("Welcome Admin!.\nYour name is: "+user.getName()+"\nYour ID is: "+user.getID()+"\nYour Phone is: "+user.getPhone());

              }

          } else {
              System.out.println("User not found");
              System.exit(0);
          }
          return user;
      }


}
