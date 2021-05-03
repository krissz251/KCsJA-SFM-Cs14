package hu.unideb.inf.businesslogic.Interfaces;
import hu.unideb.inf.businesslogic.RequestModels.*;
import hu.unideb.inf.businesslogic.ResultModels.*;
import hu.unideb.inf.dataaccess.Entities.*;

import java.util.List;

public interface IOrderData {
    //checkout oldalhoz tartozó véglegesített adatok
    //rendelés információ, végösszeg,stb
    GetCheckoutResult GetCheckOut(int orderId);
    //rendelés leadása, visszaad egy komplett rendelés modelt
    FullOrderResult AddFullOrder(FullOrderRequest request);
    //visszaad egy komplett rendelés modelt id alapján
    FullOrderResult GetFullOrder(int id);
    GetOrdersListResult GetOrdersList(GetOrdersListRequest request);
    GetItemsListResult GetItemsList(GetItemsListRequest request);
    GetOrderItemsListResult GetOrderItemsList(GetOrderItemsListRequest request);
    Order GetOrderById(int id);
    OrderItem GetOrderItemById(int id);
    Item GetItemById(int id);
    Order AddOrder(AddOrderRequest request);
    OrderItem AddOrderItem(AddOrderItemRequest request);
    void DeleteOrderItemById(int id);
    Order SetOrder(SetOrderRequest request);
    Item SetItem(SetItemRequest request);
    List<FullOrderRequest> GetListOfDefaultOrders();
}
