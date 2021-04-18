package hu.unideb.inf.businesslogic.ResultModels.DaoResults;

import hu.unideb.inf.dataaccess.Entities.Item;

import java.util.List;

public class ItemsResult {
    public List<Item> Items;
    public int PageCount;
    public ItemsResult(List<Item> items, int pageCount){
        this.Items = items;
        this.PageCount = pageCount;
    }
}
