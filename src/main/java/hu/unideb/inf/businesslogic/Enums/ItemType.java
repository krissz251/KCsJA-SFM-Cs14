package hu.unideb.inf.businesslogic.Enums;

public enum ItemType {
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
        }
        return null;
    }
}
