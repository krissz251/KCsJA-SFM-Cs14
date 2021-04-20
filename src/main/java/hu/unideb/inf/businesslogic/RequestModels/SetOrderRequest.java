package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Enums.OrderState;


public class SetOrderRequest {
    public int Id;
    public String Name;
    public OrderState State;
    public SetOrderRequest(int id, String name, OrderState state){
        this.Id = id;
        this.Name = name;
        this.State = state;
    }
}
