/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CS
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGoodGetCard() {
        System.out.println("getCard");
        Card instance = null;
        int expResult = 13;
        int result = instance.getCard();
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testBadGetCard() {
        System.out.println("getCard");
        Card instance = null;
        int expResult = 14;
        int result = instance.getCard();
        assertEquals(expResult, result);
       
    }
    
     @Test
    public void testBoundaryGetCard() {
        System.out.println("getCard");
        Card instance = null;
        int expResult = 0;
        int result = instance.getCard();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }
    
}
