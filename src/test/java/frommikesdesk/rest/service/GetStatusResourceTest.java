/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.frommikesdesk.rest.service;

import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import frommikesdesk.rest.service.GetStatusResource;

/**
 *
 * @author Michael Silveus <michaelsilveus@gmail.com>
 */
public class GetStatusResourceTest {
    
    public GetStatusResourceTest() {
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

    /**
     * Test of getXMLStatus method, of class GetStatusResource.
     */
    @Test
    public void testGetXMLStatus() {
        System.out.println("getXMLStatus");
        GetStatusResource instance = new GetStatusResource();
        Response result = instance.getXMLStatus();
        assertNotNull(result);
    }

    /**
     * Test of getJSONStatus method, of class GetStatusResource.
     */
    @Test
    public void testGetJSONStatus() {
        System.out.println("getJSONStatus");
        GetStatusResource instance = new GetStatusResource();
        Response result = instance.getJSONStatus();
        assertNotNull(result);
    }

    /**
     * Test of getTextStatus method, of class GetStatusResource.
     */
    @Test
    public void testGetTextStatus() {
        System.out.println("getTextStatus");
        GetStatusResource instance = new GetStatusResource();
        Response result = instance.getTextStatus();
        assertNotNull(result);
    }

    /**
     * Test of getStatus method, of class GetStatusResource.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        GetStatusResource instance = new GetStatusResource();
        Response result = instance.getStatus();
        assertNotNull(result);
    }
    
}
