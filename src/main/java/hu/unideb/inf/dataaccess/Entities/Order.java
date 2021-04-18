package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.dataaccess.IEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Order implements IEntity<Order> {
    public int Id;
    public String Name;
    public Date Date;
    public int State;
    @Override
    public Order Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            Name = rs.getString("C_NAME");
            Date = Date.valueOf(rs.getString("C_DATE"));
            State = rs.getInt("C_STATE");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this;
    }
}
