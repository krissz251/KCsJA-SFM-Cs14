package hu.unideb.inf.businesslogic.RequestModels;

public class AddBookingRequest {
    public String Name;
    public int Table;
    public AddBookingRequest(int table, String name){
        this.Name = name;
        this.Table = table;
    }
}
