package seo.dale.practice.pattern.state.vending.state;

import seo.dale.practice.pattern.state.vending.VendingMachine;
import seo.dale.practice.pattern.state.vending.model.Product;

public class OutOfOrderState implements VendingMachineState {

    @Override
    public void insertCoin(int coin, VendingMachine machine) {
        throw new RuntimeException("Out of order");
    }

    @Override
    public Product selectProduct(int productId, VendingMachine machine) {
        throw new RuntimeException("Out of order");
    }
    
}
