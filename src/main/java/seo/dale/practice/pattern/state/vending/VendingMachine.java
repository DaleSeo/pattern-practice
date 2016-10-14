package seo.dale.practice.pattern.state.vending;

import seo.dale.practice.pattern.state.vending.model.Product;

public class VendingMachine {

    private VendingMachineState state;
    private int money;

    public VendingMachine() {
        this(new NoMoneytate(), 0);
    }

    public VendingMachine(VendingMachineState state, int money) {
        this.state = state;
        this.money = money;
    }

    public VendingMachineState getState() {
        return state;
    }

    public int getMoney() {
        return money;
    }

    public boolean hasMoney() {
        return money > 0;
    }

    public void insertCoin(int coin) {
        System.out.printf("Inserting the coin, %d.%n", coin);
        state.insertCoin(coin, this);
    }

    public void selectProduct(int productId) {
        System.out.printf("Selecting the product, %d.%n", productId);
        state.selectProduct(productId, this);
    }

    public void changeState(VendingMachineState state) {
        System.out.println(">>> Changing its state from" + this.state.getClass().getSimpleName() + " to " + state.getClass().getSimpleName() + ".");
        this.state = state;
    }

    public Product provideProduct(int productId) {
        Product product = new Product(productId, productId * 100, "Product#" + productId);
        int price = product.getPrice();
        if (price > money) {
            throw new RuntimeException(String.format("Not enough money. (price : %s, money : %s)", price, money));
        }
        money -= price;
        return new Product(productId, productId * 1000, "Product#" + productId);
    }

    public void increaseCoin(int coin) {
        this.money += coin;
    }

    private void decreaseCoin(int coin) {
        this.money += coin;
    }

    public int returnCoin() {
        int left = money;
        money = 0;
        return left;
    }

}
