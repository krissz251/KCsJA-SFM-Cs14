package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.businesslogic.Enums.OrderState;
import hu.unideb.inf.dataaccess.IEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements IEntity<Order> {
    public int Id;
    public String Name;
    public java.util.Date Date;
    public OrderState State;
    public String Title;
     public String Description;
     public String Phone;
     public String Address;
    @Override
    public Order Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            Name = rs.getString("C_NAME");
            try{
                Date = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").parse(rs.getString("C_DATE"));
            }
            catch(Exception e){
            }
            State = OrderState.fromInt(rs.getInt("C_STATE"));
            Title = rs.getString("C_TITLE");
            Description = rs.getString("C_DESCRIPTION");
            Phone = rs.getString("C_PHONE");
            Address = rs.getString("C_ADDRESS");
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
	public String getDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(Date);
	}
	public OrderState getState(){
		return State;
	}
	public String getTitle(){ return Title; }
        public String getDescription(){ return Description; }
        public String getPhone(){return Phone;}
        public String getAddress(){return Address;}
}
