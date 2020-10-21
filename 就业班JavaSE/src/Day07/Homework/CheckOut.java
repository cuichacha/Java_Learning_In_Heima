package Day07.Homework;

import java.util.ArrayList;
import java.util.List;

public class CheckOut {
    public static void main(String[] args) {
        List<Dish> dishList = new ArrayList<>();
        Dish dish1 = new Dish("酸辣土豆丝", 12, 2);
        Dish dish2 = new Dish("麻婆豆腐", 24, 2);
        Dish dish3 = new Dish("酸菜鱼", 56, 1);

        dishList.add(dish1);
        dishList.add(dish2);
        dishList.add(dish3);

        int price = 0;

        for (Dish dish : dishList) {
            System.out.println("您消费了" + dish.getQuantity() + "盘" + dish.getName());
            price += dish.getPrice() * dish.getQuantity();
        }
        System.out.println("总计" + price + "元");
    }
}

class Dish {
    private String name;
    private int price;
    private int quantity;

    public Dish() {
    }

    public Dish(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
