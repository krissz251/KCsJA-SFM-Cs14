package hu.unideb.inf.businesslogic.RequestModels;

public class AddOrderItemRequest {
    public int Id;
    public int OrderId;
    public int ItemId;
    public int Amount;
    public AddOrderItemRequest(int Id,int OrderId, int ItemId,int Amount){
        this.Id=Id;
        this.OrderId=OrderId;
        this.ItemId=ItemId;
        this.Amount=Amount;

    }
}
