package seo.dale.practice.pattern.state.vending.state;

import seo.dale.practice.pattern.state.vending.VendingMachine;
import seo.dale.practice.pattern.state.vending.model.Product;

public class NoMoneytate implements VendingMachineState {

    @Override
    public void insertCoin(int coin, VendingMachine machine) {
        machine.increaseCoin(coin);
        machine.changeState(new SelectableState());
    }

    @Override
    public Product selectProduct(int productId, VendingMachine machine) {
        throw new UnsupportedOperationException("Can't select products with no coin.");
    }

}
