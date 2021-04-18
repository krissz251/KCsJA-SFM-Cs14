package hu.unideb.inf.businesslogic.Enums;

public enum ItemType {
    NotSet,
    Base,
    Topping,
    Sauce;
    public static ItemType fromInt(int i){
        switch(i){
            case 1:{
                return Base;
            }
            case 2:{
                return Topping;
            }
            case 3:{
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
                return 1;
            }
            case Topping:{
                return 2;
            }
            case Sauce:{
                return 3;
            }
            default:{
                return 0;
            }
        }
    }
}
