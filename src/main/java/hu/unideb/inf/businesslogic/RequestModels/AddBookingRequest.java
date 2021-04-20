package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Enums.BookingState;

public class AddBookingRequest {
    public String Name;
    public int Table;
    public AddBookingRequest(String Name, int Table){
        this.Name=Name;
        this.Table=Table;

    }

}
