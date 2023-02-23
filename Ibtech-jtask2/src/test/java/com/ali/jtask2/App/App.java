package com.ali.jtask2.App;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class App extends TestCase {

    public App( String testName )
    {
        super( testName );
    }
 
 
    public static Test suite()
    {
        return new TestSuite( App.class );
    }

  

 
    public void testApp()
    {
        assertTrue( true );
    }

}
