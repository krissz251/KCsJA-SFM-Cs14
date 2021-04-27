package hu.unideb.inf.businesslogic;


import hu.unideb.inf.businesslogic.Enums.BookingState;
import hu.unideb.inf.businesslogic.Enums.ItemType;
import hu.unideb.inf.businesslogic.Enums.OrderState;
import hu.unideb.inf.businesslogic.RequestModels.*;
import hu.unideb.inf.businesslogic.ResultModels.*;
import hu.unideb.inf.businesslogic.Interfaces.*;
import hu.unideb.inf.dataaccess.Entities.*;
import hu.unideb.inf.dataaccess.SQLContext;

import java.util.ArrayList;
import java.util.List;

public class BusinessData implements IBookingData, IOrderData, IUserData{

    @Override
    public boolean Login(String username, String password){
        SQLContext context = new SQLContext();
        var result = context.LoginUser(username,password);
        context.Dispose();
        return result;
    }

    @Override
    public GetCheckoutResult GetCheckOut(int orderId) {
        SQLContext context = new SQLContext();
        var orderItemsResult = context.GetOrderItems(new GetOrdersListRequest(0,100));
        int sum = 0;
        for (var orderItem: orderItemsResult.OrderItems) {
            var item = context.GetItemById(orderItem.ItemId);
            if(item != null){
                sum += item.Price;
            }
        }
        return new GetCheckoutResult(sum);
    }

    @Override
    public FullOrderResult AddFullOrder(FullOrderRequest request) {
        FullOrderResult result = null;
        SQLContext context = new SQLContext();
        Order order = new Order();
        order.Name = request.Name;
        order.State = OrderState.InProgress;
        order.Title = request.Title;
        Order resultOrder = context.AddOrder(order);
        List<OrderItem> orderItemsResult = new ArrayList<>();
        if(resultOrder != null){
            for (var item:request.OrderItems) {
                OrderItem orderItem = new OrderItem();
                orderItem.OrderId = resultOrder.Id;
                orderItem.ItemId = item;
                var resultItem = context.AddOrderItem(orderItem);
                if(resultItem != null){
                    orderItemsResult.add(resultItem);
                }
            }
            int fullPrice = GetCheckOut(resultOrder.Id).Sum;
            result = new FullOrderResult(
                    resultOrder.Id,
                    orderItemsResult,
                    fullPrice,
                    resultOrder.Name,
                    resultOrder.Date,
                    resultOrder.Title
            );

        }
        context.Dispose();
        return result;
    }

    @Override
    public FullOrderResult GetFullOrder(int id) {
        FullOrderResult result = null;
        SQLContext context = new SQLContext();
        var resultOrder = context.GetOrderById(id);
        var orderItemsResult = context.GetOrderItems(new GetOrdersListRequest(0,100));
        int fullPrice = GetCheckOut(id).Sum;
        if(resultOrder != null){
            result = new FullOrderResult(
                    resultOrder.Id,
                    orderItemsResult.OrderItems,
                    fullPrice,
                    resultOrder.Name,
                    resultOrder.Date,
                    resultOrder.Title
            );
        }
        context.Dispose();
        return result;
    }

    @Override
    public List<Booking> GetActiveBookings() {
		SQLContext context =new SQLContext();
		var result = context.GetActiveBookings();
		context.Dispose();
        return result;
    }

    @Override
    public GetUsersListResult GetUsersList(GetUsersListRequest request){
        SQLContext context = new SQLContext();
        var result = context.GetUsers(request);
        context.Dispose();
        return new GetUsersListResult(result.Users,request);
    }

    @Override
    public GetOrdersListResult GetOrdersList(GetOrdersListRequest request){
        SQLContext context = new SQLContext();
        var result = context.GetOrders(request);
        context.Dispose();
        request.PageCount = result.PageCount;
        return new GetOrdersListResult(result.Orders,request);
    }

    @Override
    public GetOrderItemsListResult GetOrderItemsList(GetOrderItemsListRequest request) {
        SQLContext context = new SQLContext();
        var result = context.GetOrderItems(request);
        context.Dispose();
        request.PageCount = result.PageCount;
        return new GetOrderItemsListResult(result.OrderItems,request);
    }

    @Override
    public GetBookingsListResult GetBookingsList(GetBookingsListRequest request) {
		SQLContext context = new SQLContext();        
        var result = context.GetBookings(request);       
        context.Dispose();
        request.PageCount = result.PageCount;
        return new GetBookingsListResult(result.Bookings,request); 
	}

    @Override
    public GetItemsListResult GetItemsList(GetItemsListRequest request) {
        SQLContext context = new SQLContext();
        var result = context.GetItems(request);
        context.Dispose();
        request.PageCount = result.PageCount;
        return new GetItemsListResult(result.Items,request);
    }

    @Override
    public User GetUserById(int id){
        SQLContext context = new SQLContext();
        var result = context.GetUserById(id);
        context.Dispose();
        return result;
    }

    @Override
    public Booking GetBookingById(int id) {
        SQLContext context = new SQLContext();
        var result = context.GetBookingById(id);
        context.Dispose();
        return result;
    }

    @Override
    public Item GetItemById(int id) {
        SQLContext context = new SQLContext();
        var result = context.GetItemById(id);
        context.Dispose();
        return result;
    }

    @Override
    public Order GetOrderById(int id) {
        SQLContext context = new SQLContext();
        var result = context.GetOrderById(id);
        context.Dispose();
        return result;
    }

    @Override
    public OrderItem GetOrderItemById(int id) {
        SQLContext context = new SQLContext();
        var result = context.GetOrderItemById(id);
        context.Dispose();
        return result;
    }

    @Override
    public User AddUser(AddUserRequest request){
        SQLContext context = new SQLContext();
        User newUser = new User();
        newUser.Name = request.UserName;
        newUser.Password = request.Password;
        var result = context.AddUser(newUser);
        context.Dispose();
        return result;
    }

    @Override
    public Order AddOrder(AddOrderRequest request) {
        return null;
    }

    @Override
    public OrderItem AddOrderItem(AddOrderItemRequest request) {
        SQLContext context = new SQLContext();
        OrderItem newOrderItem = new OrderItem();
        newOrderItem.OrderId = request.OrderId;
        newOrderItem.ItemId=request.ItemId;
        var result = context.AddOrderItem(newOrderItem);
        context.Dispose();
        return result;
    }

    @Override
    public Booking AddBooking(AddBookingRequest request) {
        SQLContext context = new SQLContext();
        var newBooking = new Booking();
        newBooking.State = BookingState.Booked;
        newBooking.Name = request.Name;
        newBooking.Table = request.Table;
        context.AddBooking(newBooking);
        context.Dispose();
        return newBooking;
    }

    @Override
    public void DeleteUserById(int id){
        SQLContext context = new SQLContext();
        context.DeleteUserById(id);
        context.Dispose();
    }

    @Override
    public void DeleteOrderItemById(int id) {
        SQLContext context = new SQLContext();
        context.DeleteOrderItemById(id);
        context.Dispose();
    }

    @Override
    public void DeleteBookingById(int id) {
        SQLContext context = new SQLContext();
        context.DeleteBookingById(id);
        context.Dispose();
    }

    @Override
    public User SetUser(SetUserRequest request){
        SQLContext context = new SQLContext();
        var user = context.GetUserById(request.Id);
        user.Password = request.Password;
        user.Name = request.UserName;
        var result = context.SetUser(user);
        context.Dispose();
        return result;
    }

    @Override
    public Order SetOrder(SetOrderRequest request) {
        SQLContext context = new SQLContext();
        var order = context.GetOrderById(request.Id);
        order.Name = request.Name;
        order.State = request.State;
        order.Title = request.Title;
        var result = context.SetOrder(order);
        context.Dispose();
        return result;
    }

    @Override
    public List<FullOrderRequest> GetListOfDefaultOrders() {
        List<FullOrderRequest> result = new ArrayList<>();
        List<Integer> itemsInOrder = new ArrayList<>();
        itemsInOrder.add(1);
        itemsInOrder.add(10);
        itemsInOrder.add(4);
        itemsInOrder.add(5);
        itemsInOrder.add(8);
        result.add(new FullOrderRequest(CloneList(itemsInOrder),"","Szalámis"));
        itemsInOrder.clear();
        itemsInOrder.add(1);
        itemsInOrder.add(11);
        itemsInOrder.add(12);
        itemsInOrder.add(4);
        itemsInOrder.add(6);
        result.add(new FullOrderRequest(CloneList(itemsInOrder),"","Gombás"));
        itemsInOrder.clear();
        itemsInOrder.add(1);
        itemsInOrder.add(10);
        itemsInOrder.add(9);
        itemsInOrder.add(4);
        itemsInOrder.add(6);
        itemsInOrder.add(12);
        result.add(new FullOrderRequest(CloneList(itemsInOrder),"","Olaszos"));
        itemsInOrder.clear();
        itemsInOrder.add(1);
        itemsInOrder.add(10);
        itemsInOrder.add(4);
        itemsInOrder.add(5);
        itemsInOrder.add(6);
        itemsInOrder.add(7);
        itemsInOrder.add(8);
        itemsInOrder.add(9);
        result.add(new FullOrderRequest(CloneList(itemsInOrder),"","Extra"));
        itemsInOrder.clear();
        itemsInOrder.add(1);
        itemsInOrder.add(11);
        itemsInOrder.add(4);
        itemsInOrder.add(7);
        itemsInOrder.add(8);
        itemsInOrder.add(12);
        result.add(new FullOrderRequest(CloneList(itemsInOrder),"","Vega"));
        //result.add(new FullOrderRequest(itemsInOrder,"","Kívánság"));
        return result;
    }

    @Override
    public Booking SetBooking(SetBookingRequest request) {
        SQLContext context = new SQLContext();
        var booking = context.GetBookingById(request.Id);
        booking.State = request.State;
        var result = context.SetBooking(booking);
        context.Dispose();
        return result;
    }
    private <T> List<T> CloneList(List<T> list){
        List<T> result = new ArrayList<>();
        for (var item: list) {
            result.add(item);
        }
        return result;
    }
}
