package com.softserve.edu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
    private static Calc calc;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass");
        calc = new Calc();
    }

//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//        System.out.println("@AfterClass");
//    }

//    @Before
//    public void setUp() throws Exception {
//        System.out.println("\t@Before");
//    }

//    @After
//    public void tearDown() throws Exception {
//        System.out.println("\t@After");
//    }

    @Test
    public void add1() {
        System.out.println("\t\t@Test add1()");
        //int i = 1 / 10;
        //System.out.println("\t\t\ti = " + i);
        // fail("Not yet implemented");
        //
        //Calc calc = new Calc();
        double actual;
        double expected;
        //
        expected = 4;
        actual = calc.add(2, 2);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void add2() {
        System.out.println("\t\t@Test add2()");
        //
        //Calc calc = new Calc();
        double actual;
        double expected;
        //
        expected = 4;
        actual = calc.add(3, 1);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void div1() {
        System.out.println("\t\t@Test div1()");
        //
        //Calc calc = new Calc();
        double actual;
        double expected;
        //
        expected = 4;
        actual = calc.div(20, 5);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void div2() {
        System.out.println("\t\t@Test div2()");
        //
        //Calc calc = new Calc();
        double actual;
        double expected;
        //
        expected = 2.5;
        actual = calc.div(20, 8);
        Assert.assertEquals(expected, actual, 0.01);
    }

    
}
