package domain;

public class Manager {
    private String id;
    private String name;
    private String gender;
    private String phoneNUmber;

    public Manager() {
    }

    public Manager(String id, String name, String gender, String phoneNUmber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNUmber = phoneNUmber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNUmber='" + phoneNUmber + '\'' +
                '}';
    }
}
