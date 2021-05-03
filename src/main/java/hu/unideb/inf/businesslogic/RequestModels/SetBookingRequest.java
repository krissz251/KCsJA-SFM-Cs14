package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Enums.BookingState;

public class SetBookingRequest {
    public int Id;
    public BookingState State;
    public SetBookingRequest(int id, BookingState state){
        this.Id = id;
        this.State = state;
    }
}
