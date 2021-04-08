package hu.unideb.inf.businesslogic.ResultModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;
import hu.unideb.inf.businesslogic.Interfaces.IPagedData;
import hu.unideb.inf.dataaccess.Entities.User;

import java.util.List;

public class GetUsersListResult extends IPagedData<User> {
    public GetUsersListResult(List<User> users, IPaged page){
        this.Collection = users;
        this.CurrentPage = page.CurrentPage;
        this.PageCount = page.PageCount;
        this.PageSize = page.PageSize;
    }
}
