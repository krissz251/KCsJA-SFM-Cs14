package hu.unideb.inf.businesslogic.RequestModels;

public class SetUserRequest {
    public String UserName;
    public String Password;
    public int Id;
    public SetUserRequest(int id, String userName,String password){
        this.UserName = userName;
        this.Password = password;
        this.Id = id;
    }
}
