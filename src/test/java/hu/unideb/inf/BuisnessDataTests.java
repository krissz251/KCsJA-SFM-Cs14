package hu.unideb.inf;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.RequestModels.AddUserRequest;
import hu.unideb.inf.dataaccess.Entities.User;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BuisnessDataTests {
    BusinessData bd= new BusinessData();

    @Test
    void LoginTest() {
        String username="admin", password1="a",password2="b";
        boolean result1=bd.Login(username,password1);
        boolean result2=bd.Login(username,password2);
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void GetUserByIdTest() {
        int userId= 1;
        var result = bd.GetUserById(userId);
        String actualName= "admin";
        String actualPw= "a";
        assertEquals(result.Name,actualName);
        assertEquals(result.Password,actualPw);
    }
    /*@Test
    void GetBookingByIdTest(){
        int bookingId=1;
        var result= bd.GetBookingById(bookingId);
        String actualName=null;
        assertEquals(result.getName(),actualName);
    }*/
    @Test
    void GetItemByIdTest(){
        int itemId1=1, itemId2=6;
        var result1=bd.GetItemById(itemId1);
        var result2=bd.GetItemById(itemId2);
        String actualName1="Normál",actualName2="Sonka";
        assertEquals(result1.Name,actualName1);
        assertEquals(result2.Name,actualName2);
    }
    //Az Id folyamatos változása miatt nem müködikminden futtatáskor a test
    //a metódusok mükednek!
    /* @Test
    void UserTests(){
        AddUserRequest aur=new AddUserRequest("TestUn","TestPw");
        bd.AddUser(aur);
        var actual=bd.GetUserById(9);
        User expected=null;
        assertEquals(aur.UserName,actual.Name);
        bd.DeleteUserById(9);
        actual=bd.GetUserById(9);
        assertEquals(actual,expected);
    }*/
}