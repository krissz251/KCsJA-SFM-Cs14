package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.dataaccess.IEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            Date = Date.valueOf(rs.getString("C_DATE"));
            State = rs.getInt("C_STATE");
            Table = rs.getInt("C_TABLE");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this;
    }
}
