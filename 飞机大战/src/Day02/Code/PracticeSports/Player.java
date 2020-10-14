package Day02.Code.PracticeSports;

public abstract class Player extends Human {
    public Player() {
    }

    public Player(String name, int age) {
        super(name, age);
    }


    public abstract void play();
}
