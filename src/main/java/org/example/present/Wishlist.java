package org.example.present;
import static org.example.Utility.utility.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wishlist {
 public int wishlistid;
 public int userid;
 public int productid;

public Wishlist(int wishlistid, int userid, int productid){
    this.wishlistid=wishlistid;
    this.userid=userid;
    this.productid=productid;
}
}
