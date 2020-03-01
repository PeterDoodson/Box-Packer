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
public class BoxTest {
    
    public BoxTest() {
    }
    Product z = new Product("Tool", 5, false, false);
    Product p = new Product("Nails", 1, false, false);
    Product q = new Product("Hammer", 1, false, false);
    Product r = new Product("Oversized", 41, false, false);
    Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
    Depot depot = new Depot("Main Depot", depotAddress);
    Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
    //Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
    Customer customer = new Customer("Andy Bravo", customerAddress1);
    //customer.addAddress(customerAddress2);
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    

    /**
     * Test of addProduct method, of class Box.
     */
    @Test
    public void testAddProduct_Product_int() {
        System.out.println("addProduct");
        
        
        
        Box instance = new Box(customer, depot);
        instance.addProduct(p);
        
        assertEquals("Andy Bravo\n67 Torch Rd\nTreeline\nMt High\nT799\nNails x 1\n", instance.getLabel());
        
        instance.addProduct(q, 3);
        assertEquals("Andy Bravo\n67 Torch Rd\nTreeline\nMt High\nT799\nNails x 1\nHammer x 3\n", instance.getLabel());
        
        instance.addProduct(p);
        assertEquals("Andy Bravo\n67 Torch Rd\nTreeline\nMt High\nT799\nNails x 2\nHammer x 3\n", instance.getLabel());
       
        instance.addProduct(p, 3);
        assertEquals("Andy Bravo\n67 Torch Rd\nTreeline\nMt High\nT799\nNails x 5\nHammer x 3\n", instance.getLabel());
    }


    /**
     * Test of getWeight method, of class Box.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        
        
        Box instance = new Box(customer, depot);
        instance.addProduct(p);
        
        assertEquals(1, instance.getWeight(), 0.001);
        
        instance.addProduct(q, 3);
        assertEquals(4, instance.getWeight(), 0.001);
        
        instance.addProduct(z);
        assertEquals(9, instance.getWeight(), 0.001);
    }

    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit_Product() {
        System.out.println("canFit");
        
        Box instance = new Box(customer, depot);
        
        
        assertEquals(true, instance.canFit(q));
        assertEquals(false, instance.canFit(r));
        
      
    }

    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit_Product_int() {
        System.out.println("canFit");
        
        
       
        
        Box instance = new Box(customer, depot);
        
        
        assertEquals(true, instance.canFit(q, 2));
        assertEquals(false, instance.canFit(r, 3));
    }

    /**
     * Test of remainingCapacity method, of class Box.
     */
    @Test
    public void testRemainingCapacity() {
        System.out.println("remainingCapacity");
        Box instance = new Box(customer, depot);
        instance.addProduct(z);
        
        assertEquals(35, instance.remainingCapacity(), 0.001);
        instance.addProduct(q);
        assertEquals(34, instance.remainingCapacity(), 0.001);
    }

    /**
     * Test of isFragile method, of class Box.
     */
    @Test
    public void testIsFragile() {
        System.out.println("isFragile");
        Product nonFragile = new Product("Nails", 1, false, false);
        Product fragile = new Product("Hammer", 1, true, true);
        
        
        Box instance = new Box(customer, depot);
        instance.addProduct(nonFragile);
        
        assertEquals(false, instance.isFragile());
        
        instance.addProduct(p); 
        assertEquals(false, instance.isFragile());
        
        instance.addProduct(fragile);
        assertEquals(true, instance.isFragile());
    }

    /**
     * Test of isHazardous method, of class Box.
     */
    @Test
    public void testIsHazardous() {
        System.out.println("isHazardous");
        Product nonHazardous = new Product("Nails", 1, false, false);
        Product hazardous = new Product("Hammer", 1, true, true);
        
        
        Box instance = new Box(customer, depot);
        instance.addProduct(nonHazardous);
        
        assertEquals(false, instance.isHazardous());
        
        instance.addProduct(p); 
        assertEquals(false, instance.isHazardous());
        
        instance.addProduct(hazardous);
        assertEquals(true, instance.isHazardous());
    }
    
}
