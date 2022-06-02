import java.util.*;
/**
 * Josh Knopf
 * 4/13/22
 * Catalog stoares information about a collectin of items
 */
public class Catalog {
    private String name;
    private ArrayList<Item> items = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }

    public void add(Item next) { // Adds an item to the catalog
        items.add(next);
    }

    public int size() { // Returns the size of the catalog
        return items.size();
    }

    public Item get(int index) { // Returns the coresponding item
        return items.get(index);
    }

    public String getName() { // Returns the name of the given item
        return name;
    }
}
