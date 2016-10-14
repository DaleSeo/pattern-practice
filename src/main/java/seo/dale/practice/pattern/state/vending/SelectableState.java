package seo.dale.practice.pattern.state.vending;

import seo.dale.practice.pattern.state.vending.model.Product;

public class SelectableState implements VendingMachineState {

    @Override
    public void insertCoin(int coin, VendingMachine machine) {
        machine.increaseCoin(coin);
    }

    @Override
    public Product selectProduct(int productId, VendingMachine machine) {
        Product product = machine.provideProduct(productId);
        if (!machine.hasMoney()) {
            machine.changeState(new NoMoneytate());
        }
        return product;
    }

}
