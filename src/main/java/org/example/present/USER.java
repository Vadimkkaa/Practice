package org.example.present;
import static org.example.Utility.utility.connection;

import org.example.DAO.AuthenticationDAO;
import org.example.service.AdminService;
import org.example.service.AuthenticationService;
import org.example.service.USERService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class USER {

    public static void Greetings(Scanner STDIN,int role) throws SQLException {
        if(role==1) {
            System.out.println("Do you have an account or not?\n\n 1- Yep\n 2- No\n");

            int choice;//have an acc or not

            choice = STDIN.nextInt();

            if (choice == 1) {
                System.out.println("All right. Let's proceed\n");
            } else if (choice == 2) {
                System.out.println("That's all right. Let's create one\n");
                //CREATING ACC

                System.out.println("Enter your email please(gonna be used to log in)\n");

                String mail = STDIN.next();

                int status= AuthenticationDAO.Check_mail(mail);

                if(status==0){
                    System.exit(0);
                }


                System.out.println("\n");

                System.out.println("Ok, now enter a password\n");

                String password = STDIN.next();


                System.out.println("\n");

                System.out.println("Now enter your home address\n");

                STDIN.nextLine();
                String address = STDIN.nextLine();


                System.out.println("\n");

                System.out.println("Now enter a phone number please\n");

                String phone = STDIN.next();


                System.out.println("\n");


                System.out.println("And your name :)\n");

                STDIN.nextLine();
                String name = STDIN.nextLine();


                System.out.println("\n");

                System.out.println("Well done!\n");

                //Debug

                System.out.println("Checking:\n");

                System.out.println(mail + "\n" + password + "\n" + address + "\n" + phone + "\n" + name + "\n");

                AuthenticationService.Registration(name, mail, phone, address, 1, password);
            }
        }
        System.out.println("\n"+"Now let's proceed to authentication");

        USERService user=AuthenticationService.Login(STDIN);

        if(user.getRole()==1){
            USERService.Menu(user,STDIN);
        }
        else {
            Admin.Menu(user,STDIN);

        }


    }
}
