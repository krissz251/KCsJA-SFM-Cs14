package hu.unideb.inf.businesslogic.Enums;


public enum BookingState{
    NotSet,
    Free,
    Booked;
    public static BookingState fromInt(int i){
        switch(i){
            case 1:{
                return Free;
            }
            case 2:{
                return Booked;
            }
            default:{
                return NotSet;
            }
        }
    }
    public static int toInt(BookingState val){
        switch(val){
            case Free:{
                return 1;
            }
            case Booked:{
                return 2;
            }
            default:{
                return 0;
            }
        }
    }
}
