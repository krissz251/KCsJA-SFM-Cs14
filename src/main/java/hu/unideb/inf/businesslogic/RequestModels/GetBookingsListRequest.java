package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;

public class GetBookingsListRequest extends IPaged{
    public GetBookingsListRequest(int currentPage, int pageSize){
        this.CurrentPage = currentPage;
        this.PageSize = pageSize;
    }
}
