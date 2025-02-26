package StateDesignPattern.VendingMachine.Code;

public enum Note {
    TEN(10), TWENTY(20), FIFETY(50), HUNDRED(100);
    final int value;

    Note(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    }
