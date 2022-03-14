package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void testApp() {
        System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
        System.out.println("\t***** AppTest done");
        Assert.assertTrue(true);
    }

}
