package hu.unideb.inf.businesslogic.RequestModels;

public class AddBookingRequest {
    public String Name;
    public int Tableid;
    public int Id;
   
    public AddBookingRequest(String name, int tableid){
        this.Name = name;
        this.Tableid = tableid;
        
    }
}
