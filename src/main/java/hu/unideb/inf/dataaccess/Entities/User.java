package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.dataaccess.IEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements IEntity<User> {
    public int Id;
    public String Name;
    public String Password;

    @Override
    public User Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            Name = rs.getString("C_USERNAME");
            Password = rs.getString("C_PASSWORD");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    
    
}


