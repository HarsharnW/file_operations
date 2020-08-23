package iooperations.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlWriter {
    public static void main(String[] args) {
            Customer customer = new Customer();
            customer.setName("Harsharn");
            customer.setAge(30);
            customer.setCountry("Sri Lanka");

            write(customer, "newCustomer.xml");
    }

    public static void write(Customer customer, String filePath) {
        try{
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);   // JAXBContext is the Java lib which we use to write to the xml file
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();   //Marshaller will indent text

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //Marshaller will indent text
            jaxbMarshaller.marshal(customer, file);                         // write to the file
            jaxbMarshaller.marshal(customer, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
