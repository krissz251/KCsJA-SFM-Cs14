package hu.unideb.inf.businesslogic;


import hu.unideb.inf.businesslogic.RequestModels.*;
import hu.unideb.inf.businesslogic.ResultModels.*;
import hu.unideb.inf.dataaccess.Entities.*;
import hu.unideb.inf.dataaccess.SQLContext;

public class BusinessData implements IBusinessData{

    @Override
    public boolean Login(String username, String password){
        SQLContext context = new SQLContext();
        var result = context.LoginUser(username,password);
        context.Dispose();
        return result;
    }

    @Override
    public GetCheckoutResult GetCheckOut(int orderId) {
        return null;
    }

    @Override
    public FullOrderResult AddFullOrder(FullOrderRequest request) {
        return null;
    }

    @Override
    public FullOrderResult GetFullOrder(int id) {
        return null;
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
    public GetBookingsListResult GetBookingsList(GetBookingsListRequest request) { return null; }

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
    return null;}

    @Override
    public OrderItem AddOrderItem(AddOrderItemRequest request) {
        SQLContext context = new SQLContext();
        OrderItem newOrderItem = new OrderItem();
        newOrderItem.Id = request.Id;
        newOrderItem.OrderId = request.OrderId;
        newOrderItem.ItemId=request.ItemId;
        newOrderItem.Amount=request.Amount;
        var result = context.AddOrderItem(newOrderItem);
        context.Dispose();
        return result;
    }

    @Override
    public Booking AddBooking(AddBookingRequest request) {
        return null;
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
        return null;
    }

    @Override
    public OrderItem SetOrderItem(SetOrderItemRequest request) {
        /*SQLContext context = new SQLContext();
        var orderItem = context.GetOrderItemById(request.Id);
        orderItem.Id = request.Id;
        orderItem.OrderId = request.OrderId;
        orderItem.ItemId=request.ItemId;
        orderItem.Amount=request.Amount;
        var result = context.(orderItem);
        context.Dispose();
        return result;*/
        return null;
    }

    @Override
    public Booking SetBooking(SetBookingRequest request) {
        return null;
    }
}
