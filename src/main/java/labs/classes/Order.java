package labs.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private int id;
    private String dateOrder;
    private Employees employe; // Assuming Employees is another class you have defined
    private List<Menu> orders;

    // Private constructor to enforce the use of the Builder
    private Order(Builder builder) {
        this.id = builder.id;
        this.dateOrder = builder.dateOrder;
        this.employe = builder.employe;
        this.orders = builder.orders;
    }

    // Getters for the fields
    public int getId() {
        return id;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public Employees getEmploye() {
        return employe;
    }

    public List<Menu> getOrders() {
        return orders;
    }

    // Static inner Builder class
    public static class Builder {
        private int id;
        private String dateOrder;
        private Employees employe;
        private List<Menu> orders;

        public Builder() {
            this.orders = new ArrayList<>(); // Initialize the list
        }

        public Builder setId(int id) {
            this.id = id;
            return this; // Return the Builder instance
        }

        public Builder setDateOrder(String dateOrder) {
            this.dateOrder = dateOrder;
            return this; // Return the Builder instance
        }

        public Builder setEmploye(Employees employe) {
            this.employe = employe;
            return this; // Return the Builder instance
        }

        public Builder addMenu(Menu menu) {
            this.orders.add(menu);
            return this; // Return the Builder instance
        }

        // Build method to create an Order instance
        public Order build() {
            return new Order(this);
        }

        public Object setNameProducts(String coffee) {
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(id).append("\n")
                .append("Date of Order: ").append(dateOrder).append("\n")
                .append("Employee: ").append(employe).append("\n") // Customize toString in Employees if needed
                .append("Ordered Items: \n");

        for (Menu item : orders) {
            sb.append("- ").append(item.getNameProducts()).append("\n");
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Menu product_1 = new Builder().setId(1).setNameProducts("Coffee").setPrice(25).setWeight(200).build();
        Menu product_2 = new Builder().setId(2).setNameProducts("Tost").setPrice(35).setWeight(170).build();

        Employees employees_1 = new Employees.Builder().setPassportSeriesNumber("FD3644").setFullName("Nina Dobro").setBirthDay("2001-08-15").setPosition("Meneger").setSalary(20010).build();

        List<Menu> orders = new ArrayList<>(Arrays.asList(product_1,product_2));

        Order order_1 = new Order.Builder()
                .setId(1)
                .setDateOrder("2024-08-19")
                .setEmploye(employees_1)
                .addMenu(product_1)
                .addMenu(product_2)
                .build();

        System.out.println(order_1);
    }
}

