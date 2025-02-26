package StateDesignPattern.VendingMachine.Code;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5);
    int value;
    Coin(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
