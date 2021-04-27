package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.dataaccess.Entities.OrderItem;

import java.util.List;

public class FullOrderRequest {
    public List<Integer> OrderItems;
    public String Name;
    public String Title;
    public String Description;
    public FullOrderRequest(List<Integer> orderItems,String name, String title, String description){
        this.OrderItems = orderItems;
        this.Name = name;
        this.Title = title;
        this.Description = description;
    }
}
