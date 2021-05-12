package hu.unideb.inf.businesslogic.ResultModels.DaoResults;

import hu.unideb.inf.dataaccess.Entities.User;

import java.util.List;

public class UsersResult {
    public List<User> Users;
    public int PageCount;
    public UsersResult(List<User> users,int pageCount){
        this.Users = users;
        this.PageCount = pageCount;
    }
}
