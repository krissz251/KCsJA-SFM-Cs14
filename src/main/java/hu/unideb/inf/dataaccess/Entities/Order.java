package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.businesslogic.Enums.OrderState;
import hu.unideb.inf.dataaccess.IEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Order implements IEntity<Order> {
    public int Id;
    public String Name;
    public Date Date;
    public OrderState State;
    public String Title;
    @Override
    public Order Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            Name = rs.getString("C_NAME");
            Date = Date.valueOf(rs.getString("C_DATE"));
            State = OrderState.fromInt(rs.getInt("C_STATE"));
            Title = rs.getString("C_TITLE");
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
	public Date getDate(){
		return Date;
	}
	public OrderState getState(){
		return State;
	}
	public String getTitle(){ return Title; }
}
