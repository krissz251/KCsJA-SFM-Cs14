package hu.unideb.inf.businesslogic.RequestModels;

public class AddBookingRequest {
    public String Name;
    public int Table;
    public String Phone;
    public String Description;
    public AddBookingRequest(int table, String name, String phone, String description){
        this.Name = name;
        this.Table = table;
        this.Phone = phone;
        this.Description = description;
    }
}
