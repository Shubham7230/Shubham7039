import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    int id;
    List<Product> products = new ArrayList<>();
    Customer customer;

    Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    void addProduct(Product p) {
        products.add(p);
    }

    void showProducts() {
        for (Product p : products) System.out.println(p.name + " " + p.price);
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order o) {
        orders.add(o);
        System.out.println(name + " placed Order " + o.id);
    }

    void showOrders() {
        for (Order o : orders) System.out.println("Order " + o.id);
    }
}

public class ECommerce{
    public static void main(String[] args) {
        Customer c1 = new Customer("Rohit");

        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 500);
        Product p3 = new Product("Keyboard", 1500);

        Order o1 = new Order(101, c1);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = new Order(102, c1);
        o2.addProduct(p3);

        c1.placeOrder(o1);
        c1.placeOrder(o2);

        System.out.println("Rohit's Orders:");
        c1.showOrders();

        System.out.println("Products in Order 101:");
        o1.showProducts();

        System.out.println("Products in Order 102:");
        o2.showProducts();
    }
}
