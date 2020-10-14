package domain;

public class Subway {
    private String number;
    private String name;
    private String line;

    public Subway() {
    }

    public Subway(String number, String name, String line) {
        this.number = number;
        this.name = name;
        this.line = line;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "Subway{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", line='" + line + '\'' +
                '}';
    }
}
