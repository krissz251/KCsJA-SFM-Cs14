package hu.unideb.inf.businesslogic;


import hu.unideb.inf.businesslogic.Interfaces.IPagedData;
import hu.unideb.inf.businesslogic.RequestModels.AddUserRequest;
import hu.unideb.inf.businesslogic.RequestModels.GetUsersListRequest;
import hu.unideb.inf.businesslogic.RequestModels.SetUserRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetOrdersListResult;
import hu.unideb.inf.businesslogic.ResultModels.GetUsersListResult;
import hu.unideb.inf.dataaccess.Entities.User;
import hu.unideb.inf.dataaccess.SQLContext;

public class BusinessData {

    public boolean Login(String username, String password){
        SQLContext context = new SQLContext();
        var result = context.LoginUser(username,password);
        context.Dispose();
        return result;
    }

    public GetUsersListResult GetUsersList(GetUsersListRequest request){
        SQLContext context = new SQLContext();
        var result = context.GetUsers(request);
        context.Dispose();
        return new GetUsersListResult(result.Users,request);
    }
    public GetOrdersListResult GetOrdersList(GetUsersListRequest request){
        SQLContext context = new SQLContext();
        var result = context.GetOrders(request);
        context.Dispose();
        request.PageCount = result.PageCount;
        return new GetOrdersListResult(result.Orders,request);
    }
    public User GetUserById(int id){
        SQLContext context = new SQLContext();
        var result = context.GetUserById(id);
        context.Dispose();
        return result;
    }
    public User AddUser(AddUserRequest request){
        SQLContext context = new SQLContext();
        User newUser = new User();
        newUser.Name = request.UserName;
        newUser.Password = request.Password;
        var result = context.AddUser(newUser);
        context.Dispose();
        return result;
    }
    public void DeleteUserById(int id){
        SQLContext context = new SQLContext();
        context.DeleteUserById(id);
        context.Dispose();
    }
    public User SetUser(SetUserRequest request){
        SQLContext context = new SQLContext();
        var user = context.GetUserById(request.Id);
        user.Password = request.Password;
        user.Name = request.UserName;
        var result = context.SetUser(user);
        context.Dispose();
        return result;
    }
}
