import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Project Name    : selenium_file_operations - class
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/22/2020
 * Time            : 3:37 PM
 * Description     :
 **/


public class XmlReaderFromXPath {

    public static void main(String[] args) {
        read("staff.xml");
    }

    public static void read(String filePath) {
        String xml = getXmlContent(new File(filePath).toURI().toString());

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression expression = xPath
                    .compile("/company/staff[@id='1001']/firstname");
            String firstName = expression.evaluate(document, XPathConstants.STRING).toString();
            System.out.println("First Name: " + firstName);
        } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String getXmlContent(String fileUrl) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConnection = null;
        InputStreamReader in = null;

        try {
            URL url = new URL(fileUrl);
            urlConnection = url.openConnection();

            if(urlConnection != null)
                urlConnection.setReadTimeout(60 * 1000);
            if (urlConnection != null && urlConnection.getInputStream() != null) {
                in = new InputStreamReader(urlConnection.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
