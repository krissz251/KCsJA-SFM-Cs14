package hu.unideb.inf.businesslogic.Enums;

public enum ItemType {
    NotSet,
    Base,
    Topping,
    Sauce;
    public static ItemType fromInt(int i){
        switch(i){
            case 0:{
                return Base;
            }
            case 1:{
                return Topping;
            }
            case 2:{
                return Sauce;
            }
            default:{
                return NotSet;
            }
        }
    }
    public static int toInt(ItemType val){
        switch(val){
            case Base:{
                return 0;
            }
            case Topping:{
                return 1;
            }
            case Sauce:{
                return 2;
            }
            default:{
                return -1;
            }
        }
    }
}
