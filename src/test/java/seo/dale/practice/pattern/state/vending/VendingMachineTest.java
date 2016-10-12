package seo.dale.practice.pattern.state.vending;

import org.junit.Before;
import org.junit.Test;
import seo.dale.practice.pattern.state.vending.state.NoMoneytate;
import seo.dale.practice.pattern.state.vending.state.OutOfOrderState;
import seo.dale.practice.pattern.state.vending.state.SelectableState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class VendingMachineTest {

    private VendingMachine machine;

    @Before
    public void setUp() {
        machine = new VendingMachine();
    }

    @Test
    public void test() {
        machine.insertCoin(100);
        assertEquals(100, machine.getMoney());
        assertEquals(new SelectableState().getClass(), machine.getState().getClass());

        machine.insertCoin(500);
        assertEquals(600, machine.getMoney());
        assertEquals(new SelectableState().getClass(), machine.getState().getClass());

        machine.selectProduct(3);
        assertEquals(300, machine.getMoney());
        assertEquals(new SelectableState().getClass(), machine.getState().getClass());

        try {
            machine.selectProduct(5);
            fail();
        } catch (Exception e) {
            System.out.println("!!! " + e.getMessage());
        }

        machine.selectProduct(3);
        assertEquals(0, machine.getMoney());
        assertEquals(new NoMoneytate().getClass(), machine.getState().getClass());

        try {
            machine.selectProduct(3);
            fail();
        } catch (Exception e) {
            System.out.println("!!! " + e.getMessage());
        }

        machine.changeState(new OutOfOrderState());

        try {
            machine.insertCoin(100);
            fail();
        } catch (Exception e) {
            System.out.println("!!! " + e.getMessage());
        }
    }

}