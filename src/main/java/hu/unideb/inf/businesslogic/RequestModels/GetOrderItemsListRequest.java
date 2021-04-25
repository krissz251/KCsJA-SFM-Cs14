package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;

public class GetOrderItemsListRequest extends IPaged {
    public GetOrderItemsListRequest(int currentPage, int pageSize) {
        this.CurrentPage = currentPage;
        this.PageSize = pageSize;
    }
}
