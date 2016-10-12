package seo.dale.practice.pattern.state.vending.state;

import seo.dale.practice.pattern.state.vending.VendingMachine;
import seo.dale.practice.pattern.state.vending.model.Product;

public interface VendingMachineState {

    void insertCoin(int coin, VendingMachine machine);

    Product selectProduct(int productId, VendingMachine machine);

}
