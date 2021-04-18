package hu.unideb.inf.businesslogic.ResultModels;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;
import hu.unideb.inf.businesslogic.Interfaces.IPagedData;
import hu.unideb.inf.dataaccess.Entities.Item;

import java.util.List;

public class GetItemsListResult extends IPagedData<Item>  {
    public GetItemsListResult(List<Item> items, IPaged page){
        this.Collection = items;
        this.CurrentPage = page.CurrentPage;
        this.PageCount = page.PageCount;
        this.PageSize = page.PageSize;
    }
}
