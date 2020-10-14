package Day17.Code;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;

public class XmlParseDemo {
    public static void main(String[] args) {

        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(new File("/Users/willdufresne/Documents/黑马Java/就业班/src/Day17/xml/Students1.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        ArrayList<Student> list = new ArrayList<>();
        if (document != null) {
            Element rootElement = document.getRootElement();
            for (Element element : rootElement.elements()) {
                Student student = new Student(element.attributeValue("id"),
                        element.element("name").getText(),
                        Integer.parseInt(element.element("age").getText()));
                list.add(student);
            }

            rootElement.elements().forEach(new Consumer<Element>() {
                @Override
                public void accept(Element element) {
                    Student student = new Student(element.attributeValue("id"),
                            element.element("name").getText(),
                            Integer.parseInt(element.element("age").getText()));
                    list.add(student);
                }
            });

            rootElement.elements().forEach((element) -> {
                Student student = new Student(element.attributeValue("id"),
                        element.element("name").getText(),
                        Integer.parseInt(element.element("age").getText()));
                list.add(student);
            });
        }
        System.out.println(list);
    }
}

class Student {
    private String id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
