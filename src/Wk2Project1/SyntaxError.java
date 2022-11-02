/*
 * author: Alex Reveles
 * project 1
 * date: 11/1/22
 * description: Use a GUI to convert prefix expressions to postfix and postfix to prefix
 */

package Wk2Project1;

public class SyntaxError extends Exception {
    public SyntaxError() {
        super();
    }

    public SyntaxError(String message) {
        super(message);
    }
} // end class SyntaxError