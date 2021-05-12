package hu.unideb.inf.businesslogic.ResultModels.DaoResults;

import hu.unideb.inf.dataaccess.Entities.Order;

import java.util.List;

public class OrdersResult {
    public List<Order> Orders;
    public int PageCount;
    public OrdersResult(List<Order> orders, int pageCount){
        this.Orders = orders;
        this.PageCount = pageCount;
    }
}
