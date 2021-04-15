package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;


public class GetItemsListRequest extends IPaged{
    public GetItemsListRequest(int currentPage, int pageSize){
        this.CurrentPage = currentPage;
        this.PageSize = pageSize;
    }
}
