package labs.classes;

import labs.serialize.JsonSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu implements Comparator<Menu> {
    private final int id;
    private final String nameProducts;
    private final int price;
    private final int weight;

    // Constructor with @JsonCreator for deserialization
    @JsonCreator
    public Menu(@JsonProperty("id") int id,
                @JsonProperty("nameProducts") String nameProducts,
                @JsonProperty("price") int price,
                @JsonProperty("weight") int weight) {
        this.id = id;
        this.nameProducts = nameProducts;
        this.price = price;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compare(Menu o1, Menu o2) {
        return o1.getNameProducts().compareTo(o2.getNameProducts());
    }

    @Override
    public String toString() {
        return "Product ID: " + id + "\n" +
                "Name products: " + nameProducts + "\n" +
                "Price: " + price + "\n" +
                "Weight: " + weight + "\n";
    }

    public static void main(String[] args) {
        List<Menu> products = new ArrayList<>();

        // Create products using the constructor directly for demonstration
        products.add(new Menu(1, "Coffee", 180, 460));
        products.add(new Menu(2, "Tost", 120, 30));
        products.add(new Menu(3, "Latte", 90, 120));
        products.add(new Menu(4, "Bread", 40, 250));
        products.add(new Menu(5, "Milkshake", 210, 570));

        // Sort and display products
        products.sort(Comparator.comparing(Menu::getNameProducts));
        for (Menu product : products) {
            System.out.println(product);
        }

        // JSON Serialization Example
        JsonSerializer<Menu> jsonSerializer = new JsonSerializer<>(Menu.class);

        // Serialize to JSON string
        String jsonString = jsonSerializer.serialize(products.get(0)); // Serialize first product
        System.out.println("Serialized JSON:\n" + jsonString);

        // Write to JSON file
        jsonSerializer.writeToFile(products.get(0), "product.json");

        // Read from JSON file
        try {
            Menu deserializedProduct = jsonSerializer.readFromFile("product.json");
            System.out.println("Deserialized Product:\n" + deserializedProduct);
        } catch (Exception e) {
            System.err.println("Error reading from JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
