package hu.unideb.inf.businesslogic.ResultModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;
import hu.unideb.inf.businesslogic.Interfaces.IPagedData;
import hu.unideb.inf.dataaccess.Entities.Order;

import java.util.List;

public class GetOrdersListResult extends IPagedData<Order> {
    public GetOrdersListResult(List<Order> orders, IPaged page){
        this.Collection = orders;
        this.CurrentPage = page.CurrentPage;
        this.PageCount = page.PageCount;
        this.PageSize = page.PageSize;
    }
}
