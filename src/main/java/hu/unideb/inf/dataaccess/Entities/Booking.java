package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.businesslogic.Enums.BookingState;
import hu.unideb.inf.dataaccess.IEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements IEntity<Booking> {
    public int Id;
    public String Name;
    public BookingState State;
    public Date Date;
    public int Table;
    public String Phone;
    public String Description;
    @Override
    public Booking Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            Name = rs.getString("C_NAME");
            State = BookingState.fromInt(rs.getInt("C_STATE"));
            try{
                Date = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").parse(rs.getString("C_DATE"));
            }
            catch(Exception e){
            }
            Table = rs.getInt("C_TABLE");
            Phone = rs.getString("C_PHONE");
            Description = rs.getString("C_DESCRIPTION");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this;
    }
	public int getId(){
		return Id;
	}
	public String getName(){
		return Name;
	}
	public BookingState getState(){
		return State;
	}
	public int getTable(){
		return Table;
	}
	public String getPhone(){
		return Phone;
	}
	public String getDescription(){
		return Description;
	}
    public String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format(Date);
    }
}
