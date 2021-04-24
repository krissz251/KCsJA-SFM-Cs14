package hu.unideb.inf.businesslogic.Interfaces;
import hu.unideb.inf.businesslogic.RequestModels.*;
import hu.unideb.inf.businesslogic.ResultModels.*;
import hu.unideb.inf.dataaccess.Entities.*;

public interface IBookingData {
    //bejelentkezés
    boolean Login(String username, String password);
    GetUsersListResult GetUsersList(GetUsersListRequest request);
    User GetUserById(int id);
    User AddUser(AddUserRequest request);
    void DeleteUserById(int id);
    User SetUser(SetUserRequest request);
}
