package hu.unideb.inf.businesslogic.Interfaces;
import hu.unideb.inf.businesslogic.RequestModels.*;
import hu.unideb.inf.businesslogic.ResultModels.*;
import hu.unideb.inf.dataaccess.Entities.*;

import java.util.List;
public interface IBookingData {
    //visszaadja a foglalt asztalokat
    List<Booking> GetActiveBookings();
    GetBookingsListResult GetBookingsList(GetBookingsListRequest request);
    Booking GetBookingById(int id);
    Booking AddBooking(AddBookingRequest request);
    Booking SetBooking(SetBookingRequest request);
}
