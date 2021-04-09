package hu.unideb.inf.businesslogic.RequestModels;

public class AddOrderItemRequest {
    public int id;
    public int orderId;
    public int itemId;
    public int amount;
    public AddOrderItemRequest(int id,int orderId, int itemId,int amount){
        this.id=id;
        this.orderId=orderId;
        this.itemId=itemId;
        this.amount=amount;

    }
}
