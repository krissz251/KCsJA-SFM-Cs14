package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.businesslogic.Enums.BookingState;
import hu.unideb.inf.dataaccess.IEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Booking implements IEntity<Booking> {
    public int Id;
    public String Name;
    public BookingState State;
    public int Table;
    @Override
    public Booking Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            Name = rs.getString("C_NAME");
            State = BookingState.fromInt(rs.getInt("C_STATE"));
            Table = rs.getInt("C_TABLE");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this;
    }
}
