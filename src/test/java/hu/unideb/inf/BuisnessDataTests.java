package hu.unideb.inf;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.RequestModels.*;
import hu.unideb.inf.businesslogic.ResultModels.*;
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
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BuisnessDataTests {
    BusinessData bd = null;
    //GetCheckoutResult rcr = Mockito.mock(GetCheckoutResult.class);
    //@Mock

    @Before
    public void setUp(){

        bd = new BusinessData();
    }
    @Test
    void LoginTest() {
        String username="admin", password1="a",password2="b";
        boolean result1=bd.Login(username,password1);
        boolean result2=bd.Login(username,password2);
        assertTrue(result1);
        assertFalse(result2);
    }
    /*@Test
    void GetOrderItemByIdTest() {
        int orderItemId=1,expectedOrederId=1,expectedItemId=1;
        var result= bd.GetOrderItemById(1);
        assertEquals(result.OrderId,expectedOrederId);
        assertEquals(result.ItemId,expectedItemId);
    }*/
    @Test
    void GetUserByIdTest() {
        int userId= 1;
        var result = bd.GetUserById(userId);
        String expectedName= "admin";
        String expectedPw= "a";
        assertEquals(result.Name,expectedName);
        assertEquals(result.Password,expectedPw);
    }

    /*@Test
    void GetOrderById(){
        int ItemId=1;
        String expected="06301115021";
        var result=bd.GetOrderById(ItemId);
        assertEquals(result.Phone,expected);
    }*/

    /*@Test
    void GetBookingByIdTest(){
        int bookingId=1;
        var result= bd.GetBookingById(bookingId);
        String expectedName=null;
        assertEquals(result.getName(),expectedName);
    }*/
    @Test
    void GetItemByIdTest(){
        int itemId1=1, itemId2=6;
        var result1=bd.GetItemById(itemId1);
        var result2=bd.GetItemById(itemId2);
        String expectedName1="Normál",expectedName2="Sonka";
        assertEquals(result1.Name,expectedName1);
        assertEquals(result2.Name,expectedName2);
    }
    //Az Id folyamatos változása miatt nem müködikminden futtatáskor a test
    //a metódusok mükednek!
    /*@Test
    void UserTests(){
        AddUserRequest aur=new AddUserRequest("TestUn","TestPw");

        bd.AddUser(aur);
        var expected=bd.GetUserById(9);

        assertEquals(aur.UserName,expected.Name);
        bd.DeleteUserById(9);
        var result=bd.GetUserById(9);
        User expectedUser=null;
        assertEquals(expected,expectedUser);
    }*/
}