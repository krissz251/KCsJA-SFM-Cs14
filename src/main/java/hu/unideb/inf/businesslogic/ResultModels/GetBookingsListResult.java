package hu.unideb.inf.businesslogic.ResultModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;
import hu.unideb.inf.businesslogic.Interfaces.IPagedData;
import hu.unideb.inf.dataaccess.Entities.Booking;
import hu.unideb.inf.dataaccess.Entities.Item;

import java.util.List;

public class GetBookingsListResult extends IPagedData<Booking>{
    public GetBookingsListResult(List<Booking> booking, IPaged page){
        this.Collection = booking;
        this.CurrentPage = page.CurrentPage;
        this.PageCount = page.PageCount;
        this.PageSize = page.PageSize;
    }
}
