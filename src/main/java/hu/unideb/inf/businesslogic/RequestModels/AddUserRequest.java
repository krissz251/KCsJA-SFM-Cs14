package hu.unideb.inf.businesslogic.RequestModels;

public class AddUserRequest {
    public String UserName;
    public String Password;
    public AddUserRequest(String username, String password){
        this.UserName = username;
        this.Password = password;
    }
}
