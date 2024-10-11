package labs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CollectionsClass {
    private List<String> items;

    public CollectionsClass(){
        this.items = new ArrayList<>();
    }

    public List<String> getAllItems(){
        return new ArrayList<>(items);
    }

    public void clearItems(){
        items.clear();
    }

    public int countIteams(){
        return items.size();
    }

    public void sortItems(){
        Collections.sort(items);
    }

    public void addItem(String item){
        items.add(item);
    }

    public void removeItem(String item){
        items.remove(item);
    }

    public boolean containsItem(String item){
        return items.contains(item);
    }

    public static void main(String[] args) {
        CollectionsClass service = new CollectionsClass();

        service.addItem("Coffee");
        service.addItem("Tea");
        service.addItem("Cake");
        service.addItem("Tost");
        service.addItem("Late");

        System.out.println(service.containsItem("Tost"));
        System.out.println(service.containsItem("Bread"));

        service.removeItem("Late");

        System.out.println(service.containsItem("Late"));

        System.out.println(service.getAllItems());
        System.out.println(service.countIteams());

        service.sortItems();
        System.out.println(service.getAllItems());
        service.clearItems();
        System.out.println(service.getAllItems());



    }

}
