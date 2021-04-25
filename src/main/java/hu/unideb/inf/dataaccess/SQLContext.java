package hu.unideb.inf.dataaccess;

import hu.unideb.inf.businesslogic.Enums.BookingState;
import hu.unideb.inf.businesslogic.Enums.OrderState;
import hu.unideb.inf.businesslogic.Interfaces.IPaged;
import hu.unideb.inf.businesslogic.ResultModels.DaoResults.*;
import hu.unideb.inf.dataaccess.Entities.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SQLContext extends PersistentContextBase{
    String connectionString = "jdbc:mysql://localhost:3306/pizzaplanet";
    Connection conn;
    public SQLContext(){
        Connect();
    }
    public SQLContext(String connectionString){
        this.connectionString = connectionString;
        Connect();
    }
    private void Connect(){
        Connection conn = null;
        try {
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "");
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionString,connectionProps);
            System.out.println("Connected to database");
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("DBCONNECTION EXCEPTION");
        }
        this.conn = conn;
    }
    private Statement CreateStatement(){
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        }
        catch(Exception e){
            System.out.println("DBSTATEMENT EXCEPTION");
        }
        return stmt;
    }

    @Override
    public boolean LoginUser(String username, String password) {
        try {
            var stmnt = CreateStatement();
            String query = String.format("select * from T_USERS where C_USERNAME = '%s' and C_PASSWORD = '%s'",username, password);
            if(stmnt != null)
            {
                var rs = stmnt.executeQuery(query);
                if(rs.next()){
                    return new User().Map(rs).Id != 0;
                }
                else return false;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
        return false;
    }

    @Override
    public User GetUserById(int id) {
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_USERS where C_ID = "+id;
            if(stmnt != null)
            {
                var rs = stmnt.executeQuery(query);
                if(rs.next()) {
                    return new User().Map(rs);
                }
                else
                    return null;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
        return null;
    }
    @Override
    public Order GetOrderById(int id){
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_ORDERS where C_ID = "+id;
            if(stmnt != null)
            {
                var rs = stmnt.executeQuery(query);
                if(rs.next()) {
                    return new Order().Map(rs);
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
        return null;
    }

    @Override
    public OrderItem GetOrderItemById(int id) {
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_ORDERITEMS where C_ID = "+id;
            if(stmnt != null)
            {
                var rs = stmnt.executeQuery(query);
                if(rs.next()) {
                    return new OrderItem().Map(rs);
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
        return null;
    }

    @Override
    public Booking GetBookingById(int id) {
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_BOOKINGS where C_ID = "+id;
            if(stmnt != null)
            {
                var rs = stmnt.executeQuery(query);
                if(rs.next()) {
                    return new Booking().Map(rs);
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
        return null;
    }

    @Override
    public Item GetItemById(int id) {
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_ITEMS where C_ID = "+id;
            if(stmnt != null)
            {
                var rs = stmnt.executeQuery(query);
                if(rs.next()) {
                    return new Item().Map(stmnt.executeQuery(query));
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
        return null;
    }

    @Override
    public UsersResult GetUsers(IPaged request){
        ArrayList<User> result = new ArrayList<User>();
        int count = 0;
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_USERS limit "+(request.CurrentPage*request.PageSize)+", "+request.PageSize;
            String countQuery = "select count(C_ID) as count from T_USERS";
            if(stmnt != null){
                var rs = stmnt.executeQuery(query);
                while (rs.next()) {
                    result.add(new User().Map(rs));
                }
                rs = stmnt.executeQuery(countQuery);
                if(rs.next()) {
                    int c = rs.getInt("count");
                    count = c / request.PageSize + c % request.PageSize > 0 ? 1 : 0;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return new UsersResult(result,count);
    }
    @Override
    public OrdersResult GetOrders(IPaged request){
        ArrayList<Order> result = new ArrayList<Order>();
        int count = 0;
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_ORDERS limit "+(request.CurrentPage*request.PageSize)+", "+request.PageSize;
            String countQuery = "select count(C_ID) as count from T_ORDERS";
            if(stmnt != null){
                var rs = stmnt.executeQuery(query);
                while (rs.next()) {
                    result.add(new Order().Map(rs));
                }
                rs = stmnt.executeQuery(countQuery);
                if(rs.next()) {
                    int c = rs.getInt("count");
                    count = c / request.PageSize + c % request.PageSize > 0 ? 1 : 0;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return new OrdersResult(result,count);
    }
	@Override
    public BookingsResult GetBookings(IPaged request) {
        ArrayList<Booking> result = new ArrayList<Booking>();
        int count = 0;
        try {
            var stmnt = CreateStatement();
            
            String query = "select * from T_BOOKINGS limit "+(request.CurrentPage*request.PageSize)+", "+request.PageSize;
            System.out.println(query);
            String countQuery = "select count(C_ID) as count from T_BOOKINGS";
            System.out.println(countQuery);
            if(stmnt != null){
                
                var rs = stmnt.executeQuery(query);
                
                while (rs.next()) {                                       
                    result.add(new Booking().Map(rs));
                }
                
                rs = stmnt.executeQuery(countQuery);
                
                if(rs.next()) {
                    int c = rs.getInt("count");
                    count = c / request.PageSize + c % request.PageSize > 0 ? 1 : 0;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return new BookingsResult(result,count);
    }
	
    @Override
    public OrderItemsResult GetOrderItems(IPaged request) {
        ArrayList<OrderItem> result = new ArrayList<OrderItem>();
        int count = 0;
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_ORDERITEMS limit "+(request.CurrentPage*request.PageSize)+", "+request.PageSize;
            String countQuery = "select count(C_ID) as count from T_ORDERITEMS";
            if(stmnt != null){
                var rs = stmnt.executeQuery(query);
                while (rs.next()) {
                    result.add(new OrderItem().Map(rs));
                }
                rs = stmnt.executeQuery(countQuery);
                if(rs.next()) {
                    int c = rs.getInt("count");
                    count = c / request.PageSize + c % request.PageSize > 0 ? 1 : 0;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return new OrderItemsResult(result,count);
    }

    @Override
    public ItemsResult GetItems(IPaged request) {
        ArrayList<Item> result = new ArrayList<Item>();
        int count = 0;
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_ITEMS limit "+(request.CurrentPage*request.PageSize)+", "+request.PageSize;
            String countQuery = "select count(C_ID) as count from T_ITEMS";
            if(stmnt != null){
                var rs = stmnt.executeQuery(query);
                while (rs.next()) {
                    result.add(new Item().Map(rs));
                }
                rs = stmnt.executeQuery(countQuery);
                if(rs.next()) {
                    int c = rs.getInt("count");
                    count = c / request.PageSize + c % request.PageSize > 0 ? 1 : 0;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return new ItemsResult(result,count);
    }
    @Override
    public User SetUser(User newValues) {
        User result = null;
        try {
            var stmnt = CreateStatement();
            String query = String.format(
                    "update T_USERS set C_USERNAME = '%s', C_PASSWORD = '%s' where C_ID = %d",
                    newValues.Name,
                    newValues.Password,
                    newValues.Id);
            if(stmnt != null){
                stmnt.executeUpdate(query);
                result = GetUserById(newValues.Id);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return result;
        }
        return result;
    }
    @Override
    public Booking SetBooking(Booking newValues) {
        Booking result = null;
        try {
            var stmnt = CreateStatement();
            String query = String.format(
                    "update T_BOOKINGS set C_NAME = '%s', C_STATE = %d, C_TABLE = %d where C_ID = %d",
                    newValues.Name,
                    BookingState.toInt(newValues.State),
                    newValues.Table,
                    newValues.Id);
            if(stmnt != null){
                stmnt.executeUpdate(query);
                result = GetBookingById(newValues.Id);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return result;
        }
        return result;
    }
    @Override
    public Order SetOrder(Order newValues) {
        Order result = null;
        try {
            var stmnt = CreateStatement();
            String query = String.format(
                    "update T_ORDER set C_NAME = '%s', C_STATE = %d, C_DATE = '%s' where C_ID = %d",
                    newValues.Name,
                    OrderState.toInt(newValues.State),
                    newValues.Date,
                    newValues.Id);
            if(stmnt != null){
                stmnt.executeUpdate(query);
                result = GetOrderById(newValues.Id);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return result;
        }
        return result;
    }

    @Override
    public Item SetItem(Item newValues) {
        Item result = null;
        try {
            var stmnt = CreateStatement();
            String query = String.format(
                    "update T_ITEMS set C_NAME = '%s', C_AMOUNT = %d, C_PRICE = '%s' where C_ID = %d",
                    newValues.Name,
                    newValues.Amount,
                    newValues.Price,
                    newValues.Id);
            if(stmnt != null){
                stmnt.executeUpdate(query);
                result = GetItemById(newValues.Id);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return result;
        }
        return result;
    }

    @Override
    public Booking AddBooking(Booking newBooking) {
        Booking result = null;
        try {
            var stmnt = CreateStatement();
            String query = String.format(
                    "INSERT INTO T_BOOKINGS (C_NAME, C_STATE, C_TABLE) VALUES ('%s',%d,%d);",
                    newBooking.Name,
                    BookingState.toInt(newBooking.State),
                    newBooking.Table);
            String newItemQuery = "SELECT LAST_INSERT_ID() as C_ID;";
            if(stmnt != null){
                stmnt.executeUpdate(query);
                var rs = stmnt.executeQuery(newItemQuery);
                if(rs.next())
                    result = GetBookingById(rs.getInt("C_ID"));
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return result;
        }
        return result;
    }

    @Override
    public Order AddOrder(Order newBooking) {
        Order result = null;
        try {
            var stmnt = CreateStatement();
            String query = String.format(
                    "INSERT INTO T_ORDERS (C_NAME, C_STATE) VALUES ('%s',%d);",
                    newBooking.Name,
                    OrderState.toInt(newBooking.State));
            String newItemQuery = "SELECT LAST_INSERT_ID() as C_ID;";
            if(stmnt != null){
                stmnt.executeUpdate(query);
                var rs = stmnt.executeQuery(newItemQuery);
                if(rs.next())
                    result = GetOrderById(rs.getInt("C_ID"));
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return result;
        }
        return result;
    }

    @Override
    public OrderItem AddOrderItem(OrderItem newOrderItem) {
        OrderItem result = null;
        try {
            var stmnt = CreateStatement();
            String query = String.format(
                    "INSERT INTO T_ORDERITEMS (C_ORDERID, C_ITEMID) VALUES (%d,%d);",
                    newOrderItem.OrderId,
                    newOrderItem.ItemId);
            String newItemQuery = "SELECT LAST_INSERT_ID() as C_ID;";
            if(stmnt != null){
                stmnt.executeUpdate(query);
                var rs = stmnt.executeQuery(newItemQuery);
                if(rs.next())
                    result = GetOrderItemById(rs.getInt("C_ID"));
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return result;
        }
        return result;
    }

    @Override
    public User AddUser(User newUser) {
        User result = null;
        try {
            var stmnt = CreateStatement();
            String query = String.format(
                    "INSERT INTO T_USERS (C_USERNAME, C_PASSWORD) VALUES ('%s','%s');",
                    newUser.Name,
                    newUser.Password);
            System.out.println(query);
            String newItemQuery = "SELECT LAST_INSERT_ID() as C_ID;";
            if(stmnt != null){
                stmnt.executeUpdate(query);
                var rs = stmnt.executeQuery(newItemQuery);
                if(rs.next())
                    result = GetUserById(rs.getInt("C_ID"));
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            return result;
        }
        return result;
    }

    @Override
    public void DeleteUserById(int id) {
        try {
            var stmnt = CreateStatement();
            String query = "Delete FROM T_USERS where C_ID = "+id;
            if(stmnt != null){
                stmnt.executeUpdate(query);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void DeleteBookingById(int id) {
        try {
            var stmnt = CreateStatement();
            String query = "Delete FROM T_BOOKINGS where C_ID = "+id;
            if(stmnt != null){
                stmnt.executeUpdate(query);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void DeleteOrderById(int id) {
        try {
            var stmnt = CreateStatement();
            String query = "Delete FROM T_ORDERS where C_ID = "+id;
            if(stmnt != null){
                stmnt.executeUpdate(query);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void DeleteOrderItemById(int id) {
        try {
            var stmnt = CreateStatement();
            String query = "Delete FROM T_ORDERITEMS where C_ID = "+id;
            if(stmnt != null){
                stmnt.executeUpdate(query);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public List<Booking> GetActiveBookings() {
        List<Booking> result = new ArrayList<>();
        try {
            var stmnt = CreateStatement();
            String query = "select * from T_BOOKINGS where C_STATE=2;";
            if(stmnt != null){
                var rs = stmnt.executeQuery(query);
                while (rs.next()) {
                    result.add(new Booking().Map(rs));
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return result;
    }


    @Override
    public void Dispose(){
        try {
            this.conn.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}