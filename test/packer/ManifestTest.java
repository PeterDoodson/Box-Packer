/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author 92018897
 */
public class ManifestTest {
    
    public ManifestTest() {
    }
    
   // Manifest testManifest = new Manifest();
   // Product aa = new Product("Nails", 1, false, false);
    
    
    
    
    
   // manifest.addProduct(Product("Nails", 1, false, false), 12);
  //  manifest.addProduct(new Product("Ladder", 15, false, false), 2);
   // manifest.addProduct(new Product("Saw", 5, false, false), 1);
    //    manifest.addProduct(new Product("Light Bulbs", 1, false, true), 20);
     //   manifest.addProduct(new Product("Weedkiller", 2, true, false), 1);

    
    
    
    
    
    @BeforeClass
    public static void setUpClass() {
        
        System.out.println("Testing Manifest class...");
    }
    
    
    /**
     * Test of addProduct method, of class Manifest.
     */



    /**
     * Test of addProduct method, of class Manifest.
     */
    @Test
    public void testAddProduct_Product_int() {
        System.out.println("addProduct");
        Product p = new Product("Nails", 1, false, false);
        Product q = new Product("Hammer", 1, false, false);
        
        
        Manifest instance = new Manifest();
        instance.addProduct(p);
        assertEquals("Nails x 1", instance.toString());
        
        instance.addProduct(q, 3);
        assertEquals("Hammer x 3\nNails x 1", instance.toString());
        
       instance.addProduct(p);
       assertEquals("Hammer x 3\nNails x 2", instance.toString());
       
       instance.addProduct(p, 3);
       assertEquals("Hammer x 3\nNails x 5", instance.toString());
    }

    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testRemoveProduct() {
        System.out.println("removeProduct");
        Product p = new Product("Nails", 1, false, false);
        Product q = new Product("Hammer", 1, false, false);
        Product z = new Product("Tool", 1, false, false);
        
        
        Manifest instance = new Manifest();
        instance.addProduct(p);
        instance.addProduct(q, 3);
        
        instance.removeProduct(p);
        
        assertEquals("Hammer x 3", instance.toString());
        
        instance.addProduct(p);
        instance.removeProduct(q);
        
        assertEquals("Hammer x 2\nNails x 1", instance.toString());
        
        instance.addProduct(q);
        instance.removeProduct(z);
        
        assertEquals("Hammer x 3\nNails x 1", instance.toString());
        
    }

    /**
     * Test of getTotalWeight method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        Product p = new Product("Nails", 1, false, false);
        Product q = new Product("Hammer", 1, false, false);
        Product z = new Product("Tool", 5, false, false);
        
        
        Manifest instance = new Manifest();
        instance.addProduct(p);
        
        assertEquals(1, instance.getTotalWeight(), 0.001);
        
        instance.addProduct(q, 3);
        assertEquals(4, instance.getTotalWeight(), 0.001);
        
        instance.addProduct(z);
        assertEquals(9, instance.getTotalWeight(), 0.001);
    }

    /**
     * Test of getHeaviestUnder method, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("getHeaviestUnder");
        Product p = new Product("Nails", 1, false, false);
        Product q = new Product("Hammer", 1, false, false);
        Product z = new Product("Tool", 5, false, false);
        
        
        Manifest instance = new Manifest();
        instance.addProduct(z);
        
        assertEquals(null, instance.getHeaviestUnder(4));
        
        instance.addProduct(q, 3);
        assertEquals(q, instance.getHeaviestUnder(4));
        assertEquals(z, instance.getHeaviestUnder(5));
        
        instance.addProduct(p);
        assertEquals(z, instance.getHeaviestUnder(5));
        assertEquals(q, instance.getHeaviestUnder(4));
    }

    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Product p = new Product("Nails", 1, false, false);
        
        
        
        Manifest instance = new Manifest();
   
        
        assertEquals(true, instance.isEmpty());
        
        instance.addProduct(p);
        
        assertEquals(false, instance.isEmpty());
    }

    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct() {
        System.out.println("containsProduct");

        Product z = new Product("Tool", 5, false, false);
        Product p = new Product("Nails", 1, false, false);
        
        Manifest instance = new Manifest();
        instance.addProduct(z);
        
        assertEquals(false, instance.containsProduct(p));
        assertEquals(true, instance.containsProduct(z));
        
    }


    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        System.out.println("hasFragileItems");
        Product p = new Product("Nails", 1, false, false);
        Product q = new Product("Hammer", 1, true, true);
        
        
        Manifest instance = new Manifest();
        
        assertEquals(false, instance.hasFragileItems());
        
        instance.addProduct(p); 
        assertEquals(false, instance.hasFragileItems());
        
        instance.addProduct(q);
        assertEquals(true, instance.hasFragileItems());
    }
    
}
