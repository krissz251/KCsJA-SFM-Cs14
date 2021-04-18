package hu.unideb.inf.businesslogic.RequestModels;

public class AddOrderItemRequest {
    public int OrderId;
    public int ItemId;
    public AddOrderItemRequest(int OrderId, int ItemId){
        this.OrderId=OrderId;
        this.ItemId=ItemId;
    }
}
