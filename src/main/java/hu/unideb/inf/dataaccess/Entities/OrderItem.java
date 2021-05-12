package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.dataaccess.IEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItem implements IEntity<OrderItem> {
    public int Id;
    public int OrderId;
    public int ItemId;
    @Override
    public OrderItem Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            OrderId = rs.getInt("C_ORDERID");
            ItemId = rs.getInt("C_ITEMID");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this;
    }
	public int getId(){
		return Id;
	}
	public int getOrderId(){
		return OrderId;
	}
	public int getItemId(){
		return ItemId;
	}
}
