package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;

public class GetOrdersListRequest extends IPaged {
    public GetOrdersListRequest(int currentPage, int pageSize){
        this.CurrentPage = currentPage;
        this.PageSize = pageSize;
    }
}
