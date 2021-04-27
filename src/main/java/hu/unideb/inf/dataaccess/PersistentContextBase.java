package hu.unideb.inf.dataaccess;

import hu.unideb.inf.businesslogic.Interfaces.IPaged;
import hu.unideb.inf.businesslogic.ResultModels.DaoResults.*;
import hu.unideb.inf.dataaccess.Entities.*;

import java.util.ArrayList;
import java.util.List;

public abstract class PersistentContextBase {
    public abstract boolean LoginUser(String username, String password);

    public abstract User GetUserById(int id);
    public abstract Order GetOrderById(int id);
    public abstract OrderItem GetOrderItemById(int id);
    public abstract Item GetItemById(int id);
    public abstract Booking GetBookingById(int id);

    public abstract UsersResult GetUsers(IPaged request);
    public abstract OrdersResult GetOrders(IPaged request);
    public abstract OrderItemsResult GetOrderItems(IPaged request);
    public abstract ItemsResult GetItems(IPaged request);
    public abstract BookingsResult GetBookings(IPaged request);

    public abstract Booking SetBooking(Booking newValues);
    public abstract Order SetOrder(Order newValues);
    public abstract Item SetItem(Item newValues);
    public abstract User SetUser(User newValues);

    public abstract Booking AddBooking(Booking newBooking);
    public abstract Order AddOrder(Order newBooking);
    public abstract OrderItem AddOrderItem(OrderItem newOrderItem);
    public abstract User AddUser(User newUser);

    public abstract void DeleteUserById(int id);
    public abstract void DeleteBookingById(int id);
    public abstract void DeleteOrderById(int id);
    public abstract void DeleteOrderItemById(int id);

    public abstract List<Booking> GetActiveBookings();

    public abstract void Dispose();
}
