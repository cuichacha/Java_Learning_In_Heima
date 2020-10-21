package Day12.CodeReview;

import java.io.*;

public class ObjectStreamReview1 {
    public static void main(String[] args) {
        User user = new User("111", "000");

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/willdufresne/Downloads/c.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(new FileInputStream("/Users/willdufresne/Downloads/c.txt"));
            User readUser = (User) objectInputStream.readObject();
            System.out.println(readUser.getUsername() + "--" + readUser.getPassword());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream != null) {
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
    private transient String password;

    private static final long serialVersionUID = 111L;

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
