package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.dataaccess.IEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Booking implements IEntity<Booking> {
    public int Id;
    public String Name;
    public int State;
    public Date Date;
    public int Table;
    @Override
    public Booking Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            Name = rs.getString("C_NAME");
            //Date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(rs.getString("C_DATE"));          
            State = rs.getInt("C_STATE");
            Table = rs.getInt("C_TABLE");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this;
        
        
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getState() {
        return State;
    }

    public Date getDate() {
        return Date;
    }

    public int getTable() {
        return Table;
    }
    
}
