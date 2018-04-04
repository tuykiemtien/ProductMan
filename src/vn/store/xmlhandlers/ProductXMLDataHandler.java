/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.store.xmlhandlers;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import vn.store.entites.Product;

/**
 *
 * @author Nguyen Ngoc Son
 */
public class ProductXMLDataHandler extends DefaultHandler{
    private boolean productCheck = false;
    private boolean nameCheck = false;
    private boolean brandCheck = false;
    private boolean priceCheck = false;   
    private List<Product> products = new ArrayList<>();
    private Product product;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("product")){
            product = new Product();
            String id = attributes.getValue("id");
            product.setId(id);
            productCheck = true;
        }
        if(qName.equals("name")){
            nameCheck = true;
        }
        if(qName.equals("brand")){
            brandCheck = true;
        }
        if(qName.equals("price")){
            priceCheck = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("product")){
           products.add(product);
            productCheck = false;
        }
        if(qName.equals("name")){
            nameCheck = false;
        }
        if(qName.equals("brand")){
            brandCheck = false;
        }
        if(qName.equals("price")){
            priceCheck = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(nameCheck){
            product.setName(new String(ch, start, length));
            nameCheck = false;
        }
        if(brandCheck){
            product.setBrand(new String(ch, start, length));
            brandCheck = false;
        }
        if(priceCheck){
            try{
                double temp = Double.parseDouble(new String(ch, start, length));
                product.setPrice(temp);
                
            }
            catch(Exception ex){
                product.setPrice(0);
            }
            priceCheck = false;
        }
    }

    public List<Product> getProducts() {
        return products;
    }
    
    

   
    
    
    
}
