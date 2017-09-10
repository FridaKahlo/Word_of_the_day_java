/**
 * Created by Liuda on 8/5/2017.
 */

import java.io.StringReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class Main {
    public static void main(String[] args){
        System.out.println("hello world");

        try {
            String page = RequestHTTP.getHTML("https://dexonline.ro/cuvantul-zilei");
            System.out.println(page);

            XPath xxpath = XPathFactory.newInstance().newXPath();
            InputSource inputSource = new InputSource(new StringReader(page));
            String query = "//span[@class=\"def\"]/b[1]/text()";
            String result = (String) xxpath.evaluate(query, inputSource, XPathConstants.STRING);
            System.out.println(result);


        }
        catch(Exception error) {
            System.out.println("An error occurred while retrieving the page\n" + error.toString());
        }
    }
}
