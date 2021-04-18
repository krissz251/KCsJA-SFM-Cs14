package hu.unideb.inf.dataaccess.Entities;

import hu.unideb.inf.businesslogic.Enums.ItemType;
import hu.unideb.inf.dataaccess.IEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Item implements IEntity<Item> {
    public int Id;
    public String Name;
    public int Amount;
    public int Price;
    public ItemType Type;
    @Override
    public Item Map(ResultSet rs) {
        try {
            Id = rs.getInt("C_ID");
            Name = rs.getString("C_NAME");
            Amount = rs.getInt("C_AMOUNT");
            Price = rs.getInt("C_PRICE");
            Type = ItemType.fromInt(rs.getInt("C_TYPE"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this;
    }

    public String getName() {
        return Name;
    }

    public int getAmount() {
        return Amount;
    }

    public int getPrice() {
        return Price;
    }

    
    
}
