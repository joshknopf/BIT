/**
 * Josh Knopf
 * 4/13/22
 * ItemOrder stores information about a particular item and quantity ordered for
 * that item
 */
public class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getPrice() { // Returns the price of the item
        return (item.priceFor(quantity));
    }

    public Item getItem() { // Returns the item
        return item;
    }
}
