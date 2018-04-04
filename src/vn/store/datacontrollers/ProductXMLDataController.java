/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.store.datacontrollers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import vn.store.entites.Product;
import vn.store.xmlhandlers.ProductXMLDataHandler;

/**
 *
 * @author Nguyen Ngoc Son
 */
public class ProductXMLDataController {
    public static List<Product> getAllProducts() throws ParserConfigurationException, SAXException, IOException{
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        ProductXMLDataHandler handler = new ProductXMLDataHandler();
        File xmlFile = new File("src/xmldata/products.xml");
        parser.parse(xmlFile, handler);
        
        return handler.getProducts();
    }
}
