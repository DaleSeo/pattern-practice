package seo.dale.practice.pattern.state.vending;

import seo.dale.practice.pattern.state.vending.model.Product;

public interface VendingMachineState {

    void insertCoin(int coin, VendingMachine machine);

    Product selectProduct(int productId, VendingMachine machine);

}
