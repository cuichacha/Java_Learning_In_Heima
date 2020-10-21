package Day03.Homework.Practice.Animal;

public class Human {
    public void play(Animal animal) {
        animal.roar();
        if (animal instanceof Cat) {
            System.out.println("猫抓老鼠");
        }
    }
}
