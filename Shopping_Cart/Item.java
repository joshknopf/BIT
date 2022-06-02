import java.text.*;

/**
 * Josh Knopf
 * 4/13/22
 * Item stores information about an individual item
 */
public class Item {
    private String name;
    private double price;
    private double bulkPrice;
    private int bulkQuantity;
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Item(String name, double price) {
        this.name = name;
        if (price < 0) {
            throw new IllegalArgumentException("Value is too small");
        } else {
            this.price = price;
        }

    }

    public Item(String name, double price, int bulkQuantity, double bulkPrice) {
        if (price < 0 || bulkQuantity < 0 || bulkPrice < 0) {
            throw new IllegalArgumentException("Value is too small");
        } else {
            this.name = name;
            this.price = price;
            this.bulkQuantity = bulkQuantity;
            this.bulkPrice = bulkPrice;
        }
    }

    public double priceFor(int quantity) { // Returns the price for the given item, taking into account bulk purchase
        if (quantity < 0) {
            throw new IllegalArgumentException("Value is too small");
        } else {
            double total = 0;
            if (quantity >= bulkQuantity && bulkQuantity != 0) {
                int bulkExcess = quantity % bulkQuantity;
                int numBulk = quantity / bulkQuantity;
                total = (bulkExcess * price) + (numBulk * bulkPrice);
            } else {
                total = quantity * price;
            }
            return total;
        }
    }

    public String toString() { // Returns a description of the given item
        if (bulkPrice > 0) {
            return name + ", " + formatter.format(price) + " (" + bulkQuantity + " for " + formatter.format(bulkPrice)
                    + ")";
        }
        return name + ", " + formatter.format(price);
    }
}
