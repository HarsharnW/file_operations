package iooperations.xml;

import org.apache.commons.collections4.iterators.NodeListIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlReader {
    public static void main(String[] args) {
        read("staff.xml");
    }

    public static void read(String filePath){
     try {
         File xmlFile = new File(filePath);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  //Java Libs used for reading the xml file
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(xmlFile);

         doc.getDocumentElement().normalize();       // format the XML data

         System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

         NodeList nodeList = doc.getElementsByTagName("staff");         //Assign the data of STAFF tag to nodelist

         for (int i=0; i < nodeList.getLength(); i++){
             Node node = nodeList.item(i);
             System.out.println("Current element: "+node.getNodeName());

             if (node.getNodeType() == Node.ELEMENT_NODE){
                 Element element = (Element) node;
                 System.out.println("Staff Id: " +element.getAttribute("id"));
                 System.out.println("First name: " +element.getElementsByTagName("firstname").item(0).getTextContent());  //get the zeroth index value of tag first name and convert it to text
                 System.out.println("Last name: " +element.getElementsByTagName("lastname").item(0).getTextContent());
                 System.out.println("Nick name: " +element.getElementsByTagName("nickname").item(0).getTextContent());
                 System.out.println("Salary: " +element.getElementsByTagName("salary").item(0).getTextContent());
                 System.out.println("-------------------------------------------------------------------------------");
             }
         }

     } catch (ParserConfigurationException | IOException | SAXException e) {
         e.printStackTrace();
     }
    }
}
