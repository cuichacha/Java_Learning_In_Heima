package Day17.CodeReview;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.function.BiConsumer;

public class ParseXml {
    public static void main(String[] args) {
//        ReadFile(writeToFile(parseXmlToArrayList(getDocument())));
//        readFile(writeToFile(parseXmlToProperties(getDocument())));

    }

    private static ArrayList<Student> parseXmlToArrayList(Document document) {

        ArrayList<Student> list = new ArrayList<>();

        if (document != null) {
            Element rootElement = document.getRootElement();
            rootElement.elements().forEach((element -> {
                Student student = new Student(element.attributeValue("id"),
                        element.element("name").getText(),
                        Integer.parseInt(element.element("age").getText()),
                        element.element("info").getText());
                list.add(student);
            }));
        }

        return list;
    }

    private static Properties parseXmlToProperties(Document document) {
        Random random = new Random();
        int num = random.nextInt(2) + 1;
        String number = "0" + num;

        Properties properties = new Properties();

        if (document != null) {
            Element rootElement = document.getRootElement();
            for (Element element : rootElement.elements()) {
                if (number.equals(element.attributeValue("id"))) {
                    properties.put(element.element("name").getText(), element.element("age").getText());
                }
            }
        }
//        System.out.println(properties);
        return properties;
    }

    private static File writeToFile(ArrayList<Student> list) {
        File file = new File("/Users/willdufresne/Documents/黑马Java/就业班/src/Day17/CodeReview/StudentsInfo.txt");

        ObjectOutputStream objectOutputStream = null;
        try {
            file.createNewFile();
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    private static File writeToFile(Properties properties) {
        File file = new File("/Users/willdufresne/Documents/黑马Java/就业班/src/StudentsInfo.properties");
        BufferedWriter bufferedWriter = null;

        try {
            file.createNewFile();
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter finalBufferedWriter = bufferedWriter;
            properties.forEach(new BiConsumer<Object, Object>() {
                @Override
                public void accept(Object o, Object o2) {
                    try {
                        finalBufferedWriter.write((String) o);
                        finalBufferedWriter.write("=");
                        finalBufferedWriter.write((String) o2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            finalBufferedWriter.flush();
                            finalBufferedWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    private static void ReadFile(File file) {

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object o = objectInputStream.readObject();
            ArrayList<Student> arrayList = (ArrayList<Student>) o;
            System.out.println(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (objectInputStream != null) {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readFile(File file) {
        InputStream inputStream = null;
        Properties properties = new Properties();
        InputStreamReader inputStreamReader = null;

        try {
            // getResourceAsStream()方法，寻找文件的起点是JAVA项目编译之后的根目录！！！切记！！！路径不能以"/"开头。
//            inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(file.getAbsolutePath());
            inputStream = new FileInputStream(file);

            inputStreamReader = new InputStreamReader(inputStream);

            properties.load(inputStreamReader);
            properties.forEach((o1, o2) -> System.out.println(o1 + "--" + o2));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Document getDocument() {
        SAXReader saxReader = new SAXReader();
        Document document = null;

        try {
            document = saxReader.read(new File("/Users/willdufresne/Documents/黑马Java/就业班/src/Day17/xml_CodeReview/Students1.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }
}

class Student implements Serializable {
    private String id;
    private String name;
    private int age;
    private String info;

    public Student() {
    }

    public Student(String id, String name, int age, String info) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }
}