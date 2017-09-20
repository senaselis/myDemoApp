package com.mycompany.app;
import java.util.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testFound() {
      String[] array = new String[]{"AppTest", "SoftwareEngineering", "GitHub", "AppTest"};
      assertTrue(new App().search(array, "GitHub",1));
    }

    public void testNotFound() {
      String[] array = new String[]{"AppTest", "SoftwareEngineering", "GitHub"};
      assertFalse(new App().search(array, "GitHub",2));
      assertFalse(new App().search(array, "Java",1));
    }

    public void testEmptyArray() {
      String[] array = new String[]{};
      assertFalse(new App().search(array, "GitHub",1));
    }

    public void testNull() {
      assertFalse(new App().search(null, "GitHub",1));
    }

}
