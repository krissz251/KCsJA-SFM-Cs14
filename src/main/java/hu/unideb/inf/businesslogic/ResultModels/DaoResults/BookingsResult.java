package hu.unideb.inf.businesslogic.ResultModels.DaoResults;

import hu.unideb.inf.dataaccess.Entities.Booking;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Attila
 */
public class BookingsResult {
    public List<Booking> Bookings;
    public int PageCount;
    
    public BookingsResult(List<Booking> bookings, int pageCount){
        this.Bookings = bookings;
        this.PageCount = pageCount;
    }
}
