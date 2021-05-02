package hu.unideb.inf.businesslogic.ResultModels;

import hu.unideb.inf.dataaccess.Entities.OrderItem;

import java.util.Date;
import java.util.List;

public class FullOrderResult {
    public int Id;
    public List<OrderItem> OrderItems;
    public int FullPrice;
    public String Name;
    public Date Date;
    public String Title;
    public String Phone;
    public String Description;
    public String Address;
    public FullOrderResult(int id,List<OrderItem> orderItems,int fullPrice,String name,Date date,String title, String phone, String description, String address){
        this.Id = id;
        this.OrderItems = orderItems;
        this.FullPrice = fullPrice;
        this.Name = name;
        this.Date = date;
        this.Title = title;
        this.Phone = phone;
        this.Description = description;
        this.Address = address;
    }
}
