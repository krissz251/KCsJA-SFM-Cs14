package hu.unideb.inf.businesslogic;

import hu.unideb.inf.businesslogic.RequestModels.*;
import hu.unideb.inf.businesslogic.ResultModels.*;
import hu.unideb.inf.dataaccess.Entities.*;

public interface IBusinessData {
    //bejelentkezés
    boolean Login(String username, String password);
    //checkout oldalhoz tartozó véglegesített adatok
    //rendelés információ, végösszeg,stb
    GetCheckoutResult GetCheckOut(int orderId);
    //rendelés leadása, visszaad egy komplett rendelés modelt
    FullOrderResult AddFullOrder(FullOrderRequest request);
    //visszaad egy komplett rendelés modelt id alapján
    FullOrderResult GetFullOrder(int id);

    GetUsersListResult GetUsersList(GetUsersListRequest request);
    GetOrdersListResult GetOrdersList(GetOrdersListRequest request);
    GetOrderItemsListResult GetOrderItemsList(GetOrderItemsListRequest request);
    GetBookingsListResult GetBookingsList(GetBookingsListRequest request);
    GetItemsListResult GetItemsList(GetItemsListRequest request);

    User GetUserById(int id);
    Booking GetBookingById(int id);
    Item GetItemById(int id);
    Order GetOrderById(int id);
    OrderItem GetOrderItemById(int id);

    User AddUser(AddUserRequest request);
    Order AddOrder(AddOrderRequest request);
    OrderItem AddOrderItem(AddOrderItemRequest request);
    Booking AddBooking(AddBookingRequest request);

    void DeleteUserById(int id);
    void DeleteOrderItemById(int id);

    User SetUser(SetUserRequest request);
    Order SetOrder(SetOrderRequest request);
    OrderItem SetOrderItem(SetOrderItemRequest request);
    Booking SetBooking(SetBookingRequest request);

}
