package hu.unideb.inf.businesslogic.ResultModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;
import hu.unideb.inf.businesslogic.Interfaces.IPagedData;
import hu.unideb.inf.dataaccess.Entities.OrderItem;

import java.util.List;

public class GetOrderItemsListResult extends IPagedData<OrderItem> {
    public GetOrderItemsListResult(List<OrderItem> orderItems, IPaged page){
        this.Collection = orderItems;
        this.CurrentPage = page.CurrentPage;
        this.PageCount = page.PageCount;
        this.PageSize = page.PageSize;
    }
}
