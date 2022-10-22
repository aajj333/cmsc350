/*
author: Alex Reveles
date: 10-21-22
description: takes two functions and periodically checks whether one is growing larger
than the other and displays when it overtakes it
 */
package Wk1Discussion;

public class Compare {

    // first function f(n)
    public static double function_f(int n) {
        double func = 1500 * (n * n * n) - (200 * (n * n)) - (85 * n) + 160;
        return func;
    } // end function_f()

    // second function g(n)
    public static double function_g(int n) {
        double func = (((500) * (n * n)) + (1100 * n) - 275);
        return func;
    } // end function_g

    public static void main(String[] args) {

        int n = 10;     // start value
        System.out.println("n" + "\tf(n)" + "\tg(n)");

        // check while f(n) > g(n) is true every 10 int and display
        while(function_f(n) > function_g(n)) {
            System.out.println(n + " " + String.format("%.2f", function_f(n)) + " " + String.format(
                    "%.2f", function_g(n)));
            n += 10;
        }

        // display final value of n for f(n) < g(n)
        System.out.println(n + " " + String.format("%.2f", function_f(n)) + " " + String.format(
                "%.2f", function_g(n)));
        System.out.println("\nOnce n reaches " + n + ", g overtakes f");

    } // end main
} // end class