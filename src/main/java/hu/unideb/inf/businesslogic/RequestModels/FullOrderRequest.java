package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.dataaccess.Entities.OrderItem;

import java.util.List;

public class FullOrderRequest {
    public List<Integer> OrderItems;
    public String Name;
    public String Title;
    public String Description;
    public String Phone;
    public String Address;
    public FullOrderRequest(List<Integer> orderItems,String title){
        this.OrderItems = orderItems;
        this.Title = title;
    }
    public FullOrderRequest(List<Integer> orderItems,String name, String title, String description, String phone, String address){
        this.OrderItems = orderItems;
        this.Name = name;
        this.Title = title;
        this.Description = description;
        this.Phone = phone;
        this.Address = address;
    }
}
