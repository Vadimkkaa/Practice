package org.example.present;
import static org.example.Utility.utility.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Products {
    public int productid;
    public int brandid ;

    public String name;

    public String description;

    public int price;

    public String color;

    public String image;

    public Products(int productid,int brandid,String name, String description,int price,String color, String image) {
        this.productid=productid;
        this.brandid=brandid;
        this.name=name;
        this.description=description;
        this.price=price;
        this.color=color;
        this.image=image;
    }
}
