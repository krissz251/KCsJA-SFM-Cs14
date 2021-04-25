package hu.unideb.inf.businesslogic.ResultModels;

import hu.unideb.inf.dataaccess.Entities.OrderItem;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FullOrderResult {
    public int Id;
    public List<OrderItem> OrderItems;
    public int FullPrice;
    public String Name;
    public Date Date;
    public String Title;
    public FullOrderResult(int id,List<OrderItem> orderItems,int fullPrice,String name,Date date,String title){
        this.Id = id;
        this.OrderItems = orderItems;
        this.FullPrice = fullPrice;
        this.Name = name;
        this.Date = date;
        this.Title = title;
    }
}
