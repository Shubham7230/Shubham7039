import java.util.*;

abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String getType();
    public String toString() {
        return getType() + ": " + name;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
    public String getType() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
    public String getType() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
    public String getType() {
        return "Furniture";
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public T getItem(int index) {
        return items.get(index);
    }
    public List<T> getItems() {
        return items;
    }
}

class DisplayUtil {
    public static void displayAll(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            System.out.println(item);
        }
    }
}

public class WarehouseSystemItem{
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Milk"));

        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        DisplayUtil.displayAll(electronicsStorage.getItems());
        DisplayUtil.displayAll(groceriesStorage.getItems());
        DisplayUtil.displayAll(furnitureStorage.getItems());
    }
}
