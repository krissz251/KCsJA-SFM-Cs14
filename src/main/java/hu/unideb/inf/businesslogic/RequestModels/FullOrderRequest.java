package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.dataaccess.Entities.OrderItem;

import java.util.List;

public class FullOrderRequest {
    public List<OrderItem> OrderItems;
    public String Name;
    public FullOrderRequest(List<OrderItem> orderItems,String name){
        this.OrderItems = orderItems;
        this.Name = name;
    }
}
