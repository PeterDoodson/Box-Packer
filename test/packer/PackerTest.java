/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
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
public class PackerTest {
    
    public PackerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer class...");
    }
   
    /**
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts() {
        System.out.println("packProducts");
        
        
        Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        Depot depot = new Depot("Main Depot", depotAddress);
       
    
        
        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
        Customer customer = new Customer("Andy Bravo", customerAddress1);
        customer.addAddress(customerAddress2);
        

        Manifest manifest = new Manifest();
        manifest.addProduct(new Product("Hammer", 3, false, false), 1);
        manifest.addProduct(new Product("Nails", 1, false, false), 12);
    


        List<Box> done = Packer.packProducts(customer, depot, manifest);
        
        assertEquals("[Andy Bravo\n88 Camp Mine St\nRidgeway\nLowe Valley\nI998\nHammer x 1\nNails x 12", done.get(0).getLabel());
        
        manifest.addProduct(new Product("Fragile", 1, false, true), 1);
        done = Packer.packProducts(customer, depot, manifest);
        assertEquals("[Andy Bravo\n88 Camp Mine St\nRidgeway\nLowe Valley\nI998\nHammer x 1\nNails x 12\nFragile x 1\nFRAGILE", done.get(0).getLabel());
        
        manifest.addProduct(new Product("Hazardous", 1, true, false), 1);
        done = Packer.packProducts(customer, depot, manifest);
        assertEquals("[Andy Bravo\n88 Camp Mine St\nRidgeway\nLowe Valley\nI998\nHammer x 1\nNails x 12\nFragile x 1\nHazardous x 1\nFRAGILE\nHAZARDOUS", done.get(0).getLabel());
        
        manifest.addProduct(new Product("Heavy", 37, false, false), 1);
        done = Packer.packProducts(customer, depot, manifest);
        StringBuilder result = new StringBuilder();
        result.append(done.get(0));
        result.append(done.get(1));
        
        assertEquals("[Andy Bravo\n88 Camp Mine St\nRidgeway\nLowe Valley\nI998\nHeavy x 1\nHammer x 1\n\n[Andy Bravo\n88 Camp Mine St\nRidgeway\nLowe Valley\nI998\nNails x 12\nFragile x 1\nHazardous x 1\nFRAGILE\nHAZARDOUS", result.toString());
        
    }
    
}
