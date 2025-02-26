package StateDesignPattern.VendingMachine.Code;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine =  VendingMachine.getInstance();
        Product coke = new Product("Coke", 10);
        Product pepsi = new Product("Pepsi", 20);
        Product water = new Product("Water", 25);

        vendingMachine.inventory.addProduct(coke, 15);
        vendingMachine.inventory.addProduct(pepsi, 10);
        vendingMachine.inventory.addProduct(water, 30);


        vendingMachine.selectProduct(coke);

        // Insert a coin
        vendingMachine.insertCoin(Coin.FIVE);
       vendingMachine.insertCoin(Coin.FIVE);

        // Insert a note
        vendingMachine.insertNote(Note.TEN);

        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();



    }
}
