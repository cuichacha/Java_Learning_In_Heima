package PracticeExam.Code;

public final class Phone {
    String name;
    double price;
    String message;

    public Phone() {
    }

    public Phone(String name, double price, String message) {
        this.name = name;
        this.price = price;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

