package hu.unideb.inf.businesslogic.Enums;

public enum OrderState {
    NotSet,
    InProgress,
    Done;
    public static OrderState fromInt(int i){
        switch(i){
            case 1:{
                return InProgress;
            }
            case 2:{
                return Done;
            }
            default:{
                return NotSet;
            }
        }
    }
    public static int toInt(OrderState val){
        switch(val){
            case InProgress:{
                return 1;
            }
            case Done:{
                return 2;
            }
            default:{
                return 0;
            }
        }
    }
}
