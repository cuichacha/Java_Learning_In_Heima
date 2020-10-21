package Day12.Code;

import java.io.*;

public class ObjectStreamDemo1 {
    public static void main(String[] args) {
        User user = new User("啦啦", "123456");
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/willdufresne/Downloads/c.txt"));
            objectOutputStream.writeObject(user);
            objectInputStream = new ObjectInputStream(new FileInputStream("/Users/willdufresne/Downloads/c.txt"));
            Object o = objectInputStream.readObject();
            System.out.println((User) o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null && objectInputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class User implements Serializable {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
