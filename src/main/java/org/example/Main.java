
package org.example;
import java.sql.*;
import java.util.Scanner;

//import org.example.DAO.USERDAO;
import org.example.Utility.utility;

import org.example.present.USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Utility.utility.connection;



public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Hi!\nIf you are a user - print 1\nIf you are an admin - print 2\n");
        Scanner STDIN = new Scanner(System.in);
        int role=1;// admin or user

            role = STDIN.nextInt();
            if(role==1){
                System.out.println("Hi,User. Let's go\n");
                USER.Greetings(STDIN,role);
            } else if(role==2) {
                System.out.println("Welcome,Admin. Let's work\n");
                USER.Greetings(STDIN,role);
            }else{
                System.out.println("I am sorry, but you entered the wrong number. The program will shut down now\n");
                System.exit(0);
            }


        //LOGIN




       }
    }



