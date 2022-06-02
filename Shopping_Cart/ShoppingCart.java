import java.util.*;

/**
 * Josh Knopf
 * 4/13/22
 * ShoppingCart stores information about the overall order.
 */

public class ShoppingCart {
    private double totalPrice = 0.0;
    public static final double DISCOUNT_PERCENT = 0.9;
    ArrayList<ItemOrder> list;

    public ShoppingCart() {
        list = new ArrayList<>();
    }

    public void add(ItemOrder next) { // Removes any previous duplicate item and adds the new one to the ItemOrder
        for (ItemOrder io : list) {
            if (io.getItem() == next.getItem()) {
                totalPrice -= io.getPrice();
                list.remove(io);
                break;
            }
        }
        list.add(next);
        totalPrice += next.getPrice();
    }

    public void setDiscount(boolean discount) { // Applies a 10% discount to the entire order
        if (discount) {
            totalPrice = totalPrice * DISCOUNT_PERCENT;
        } else {
            totalPrice = totalPrice / DISCOUNT_PERCENT;
        }
    }

    public double getTotal() { // Returns the total price of the Shopping Cart
        return totalPrice;
    }
}
