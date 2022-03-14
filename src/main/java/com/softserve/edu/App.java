package com.softserve.edu;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //
        Calc calc = new Calc();
        System.out.println("2 + 2 = " + calc.add(2, 2));
        System.out.println("20 / 2 = " + calc.div(20, 2));
    }
}
