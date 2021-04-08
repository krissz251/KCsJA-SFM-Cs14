package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;

public class GetUsersListRequest extends IPaged {
    public GetUsersListRequest(int currentPage, int pageSize){
        this.CurrentPage = currentPage;
        this.PageSize = pageSize;
    }
}
