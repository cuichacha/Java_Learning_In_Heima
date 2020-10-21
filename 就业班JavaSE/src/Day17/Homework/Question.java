package Day17.Homework;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Question {
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();
        BufferedInputStream bufferedInputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users/willdufresne/Documents/黑马Java/就业班/src/Day17/Homework/books.xml"));
            Document document = saxReader.read(bufferedInputStream);
            Element rootElement = document.getRootElement();
            for (Element element : rootElement.elements()) {
                System.out.println(element.element("name").getText());
                System.out.println(element.element("press").getText());
                System.out.println(element.element("publicationDate").getText());
                System.out.println(element.element("price").getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
