package com.mycompany.app;

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
    public void testAppAdd()
    {
        int[] arr=new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        assertTrue( new App().app(arr , arr , 2 , 4 ,'+')==6);
        assertTrue( new App().app(arr , arr , 8 , 4 ,'-')==4);
        assertTrue( new App().app(arr , arr , 8 , 4 ,'/')==2);
        assertTrue( new App().app(arr , arr , 8 , 4 ,'*')==32);

    }
    public void testAppSubtract()
    {
        int[] arr=new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        assertTrue( new App().app(arr , arr , 8 , 4 ,'-')==4);
    }
    public void testAppDivide()
    {
        int[] arr=new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        assertTrue( new App().app(arr , arr , 8 , 4 ,'/')==2);
    }
    public void testAppMultiply()
    {
        int[] arr=new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        assertTrue( new App().app(arr , arr , 8 , 4 ,'*')==32);
    }
}
