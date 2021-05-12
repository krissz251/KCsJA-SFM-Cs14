package hu.unideb.inf;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.RequestModels.*;
import hu.unideb.inf.businesslogic.ResultModels.*;
import hu.unideb.inf.dataaccess.Entities.Booking;
import hu.unideb.inf.dataaccess.Entities.OrderItem;
import hu.unideb.inf.dataaccess.Entities.User;
import hu.unideb.inf.dataaccess.SQLContext;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class BuisnessDataTests {

    BusinessData bd = new BusinessData();
    SQLContext context  = Mockito.mock(SQLContext.class);
    //GetCheckoutResult rcr = Mockito.mock(GetCheckoutResult.class);
    /*@Mock
    //User userMock;
    BusinessData businessDataMock;
    @Before
    public void setUp(){


    }*/
    @Test
    void LoginTest() {
        when(context.LoginUser("admin","a")).thenReturn(true);
        when(context.LoginUser("admin","b")).thenReturn(false);
        String username="admin", password1="a",password2="b";
        boolean result1=bd.Login(username,password1);
        boolean result2=bd.Login(username,password2);
        boolean expected1= context.LoginUser("admin","a");
        boolean expected2= context.LoginUser("admin","b");
        assertEquals(expected1,result1);
        assertEquals(expected2,result2);
        verify(context).LoginUser("admin","a");
    }
    @Test
    void GetOrderItemByIdTest() {
        int orderItemId=1,expectedOrederId=1,expectedItemId=1;
        var result= bd.GetOrderItemById(1);
        assertEquals(result.OrderId,expectedOrederId);
        assertEquals(result.ItemId,expectedItemId);
    }
    @Test
    void GetUserByIdTest() {
        int userId= 1;
        var result = bd.GetUserById(userId);
        String expectedName= "admin";
        String expectedPw= "a";
        assertEquals(result.Name,expectedName);
        assertEquals(result.Password,expectedPw);
    }

    @Test
    void GetOrderById(){
        int orderID=1;

        String expected="Kiss Ernő";
        var result=bd.GetOrderById(orderID);
        assertEquals(result.Name,expected);
    }

    @Test
    void GetBookingByIdTest(){
        int bookingId=1;
        var result= bd.GetBookingById(bookingId);
        String expectedPhone="06301115021";
        String expectedName=null;
        assertEquals(result.Phone,expectedPhone);
    }
    @Test
    void GetItemByIdTest(){
        int itemId1=1, itemId2=6;
        var result1=bd.GetItemById(itemId1);
        var result2=bd.GetItemById(itemId2);
        String expectedName1="Normál",expectedName2="Sonka";
        assertEquals(result1.Name,expectedName1);
        assertEquals(result2.Name,expectedName2);
    }

    @Test // Tartalmazza a AddUser GetUserById SetUser DeleteUserById
    void UserTests(){
        AddUserRequest aur=new AddUserRequest("TestUn","TestPw");
        var user=bd.AddUser(aur);
        int userId=user.Id;
        var expected=bd.GetUserById(userId);
        assertEquals(aur.UserName,expected.Name);
        assertEquals(user.Name,expected.Name);
        SetUserRequest sur= new SetUserRequest(userId,"UserSet","PwSET");
        var setUser=bd.SetUser(sur);
        var expectedSet=bd.GetUserById(userId);
        assertEquals(sur.UserName,expectedSet.Name);
        assertEquals(setUser.Name,expectedSet.Name);
        bd.DeleteUserById(userId);
        var result=bd.GetUserById(userId);
        User expDeletedUser=null;
        assertEquals(expDeletedUser,result);
    }
    @Test //Tartalmazza a AddBooking GetBookingById GetActiveBookings DeleteBookingById
    void BookingTests(){
        AddBookingRequest abr= new AddBookingRequest(7, "Terp Eszeter", "06305615021", "telefonon pls!");
        var booking= bd.AddBooking(abr);
        //System.out.println(booking.Id);
        var result= bd.GetBookingById(booking.Id);
        assertEquals(abr.Name,result.Name);
        assertEquals(booking.Name,result.Name);
        var resultListBooking = bd.GetActiveBookings();
        int bookingId=-1;
        for (int i = 0; i < resultListBooking.size(); i++) {
            if(resultListBooking.get(i).Id==booking.Id){
                bookingId=i;
                break;
            }
        }
        if(bookingId>=0)
            assertEquals(resultListBooking.get(bookingId).Phone, booking.Phone);
        bd.DeleteBookingById(booking.Id);
        Booking expectedBooking= null;
        assertEquals(result.Phone,expectedBooking);
    }
    /* @Test
    void OrderItemsTests() {

        AddOrderItemRequest aoir=new AddOrderItemRequest(2,10);
        var orderItem= bd.AddOrderItem(aoir);
        var result=bd.GetOrderItemById(orderItem.Id);
        assertEquals(aoir.OrderId,result.OrderId);
        assertEquals(orderItem.ItemId,result.ItemId);
        //SetOrderItemRequest sor=new SetOrderItemRequest(order.Id,3,5,20);
        bd.DeleteUserById(orderItem.Id);
        OrderItem expDeletedOrderItems= null;
        result=bd.GetOrderItemById(orderItem.Id);
        assertEquals(expDeletedOrderItems,result);
    }*/

}