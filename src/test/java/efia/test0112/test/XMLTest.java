package efia.test0112.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;

public class XMLTest {
 
    private File file;
    private SAXReader reader;
    private Document document;

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        // String filePath
        // String xpathExpression
        // URL test = XMLTest.class.getResource("../../../");
        String filePath = "C:/workspace/TEST0112/src/main/resources/TestXML.xml";
        file = new File(filePath);
        reader = new SAXReader();
        try {
            document = reader.read(file);
            List<Node> list = document.selectNodes("//article/@level");

            Iterator<Node> iter = list.iterator();
            while (iter.hasNext()) {
                Attribute attribute = (Attribute) iter.next();
                if (attribute.getValue().equals("Intermediate"))
                    attribute.setValue("Introductory");
            }
            XMLWriter output = new XMLWriter(new FileWriter(new File(filePath)));
            output.write(document);
            output.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ok");
    }

}
