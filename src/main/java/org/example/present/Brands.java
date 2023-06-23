package org.example.present;
import static org.example.Utility.utility.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Brands {

public int brandid;
public String name;
public String description;

    public Brands(int brandid, String name, String description) {
        this.brandid=brandid;
        this.name=name;
        this.description=description;
    }
}
