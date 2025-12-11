import java.util.*;

interface Category {
    String getName();
}

class BookCategory implements Category {
    public String getName() { return "Book"; }
}

class ClothingCategory implements Category {
    public String getName() { return "Clothing"; }
}

class GadgetCategory implements Category {
    public String getName() { return "Gadget"; }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return category.getName(); }
    public String toString() { return name + " | " + category.getName() + " | " + price; }
}

class Catalog {
    private List<Product<? extends Category>> products = new ArrayList<>();
    public void addProduct(Product<? extends Category> p) { products.add(p); }
    public List<Product<? extends Category>> getProducts() { return products; }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);
    }
}

public class OnlineMarketPlace{
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Product<BookCategory> book = new Product<>("Novel", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Shirt", 800, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Phone", 15000, new GadgetCategory());

        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        DiscountUtil.applyDiscount(phone, 10);

        for (Product<? extends Category> p : catalog.getProducts()) {
            System.out.println(p);
        }
    }
}
