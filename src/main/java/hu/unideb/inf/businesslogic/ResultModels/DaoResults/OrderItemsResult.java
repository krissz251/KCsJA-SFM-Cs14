package hu.unideb.inf.businesslogic.ResultModels.DaoResults;

import hu.unideb.inf.dataaccess.Entities.OrderItem;

import java.util.List;

public class OrderItemsResult {
    public List<OrderItem> OrderItems;
    public int PageCount;
    public OrderItemsResult(List<OrderItem> orderItems, int pageCount){
        this.OrderItems = orderItems;
        this.PageCount = pageCount;
    }
}
