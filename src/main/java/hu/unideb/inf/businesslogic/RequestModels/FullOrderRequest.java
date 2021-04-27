package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.dataaccess.Entities.OrderItem;

import java.util.List;

public class FullOrderRequest {
    public List<Integer> OrderItems;
    public String Name;
    public String Title;
    public FullOrderRequest(List<Integer> orderItems,String name, String title){
        this.OrderItems = orderItems;
        this.Name = name;
        this.Title = title;
    }
}
