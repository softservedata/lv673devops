package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void testApp() {
        System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
        System.out.println("***System.getenv().JAVA_HOME = " + System.getenv().get("JAVA_HOME"));
        System.out.println("\t***** AppTest done");
        Assert.assertTrue(true);
    }

}
