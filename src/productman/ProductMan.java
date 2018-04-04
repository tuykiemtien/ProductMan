/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productman;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import vn.store.entites.Product;

import static vn.store.datacontrollers.ProductXMLDataController.getAllProducts;
/**
 *
 * @author Nguyen Ngoc Son
 */
public class ProductMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println(" Gel all products in XML file.");
        List<Product> products = getAllProducts();
        for(Product product : products){
            System.out.println(" + " + product.getId()+ ", "
                    + product.getName() + ", "
                    + product.getBrand()+", "
                    + product.getPrice());
        }
    }
    
}
