/*
 * author: Alex Reveles
 * project 1
 * date: 11/1/22
 * description: Convert prefix expressions to postfix and postfix to prefix
 */

package Wk2Project1;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.*;

public class Convert {

    //converts a prefix exp to postfix
    public static String fromPrefixToPostfix(String expression) throws SyntaxError, IOException {
        // tokenize the string containing the exp
        if(!expression.equals("")) {
            List<String> expressionToArray = tokenizeExpression(expression);
            Stack<String> operandStack = new Stack<>();
//while there are tokens if not a space, push token on reversal stack
            Collections.reverse(expressionToArray);
//loop through the expression array and check for operands. If there are operands, push onto stack
            for(String token : expressionToArray) {
                if(!isOperator(token)) {
                    operandStack.push(token + " ");
                } else {
                    try {       // pop two operands off stack
                        // create string with two operands followed by operator
                        String operandOne = operandStack.pop();
                        String operandTwo = operandStack.pop();
                        String innerExpression = operandOne + operandTwo + token + " ";
                        operandStack.push(innerExpression);     // push onto stack
                    } catch(EmptyStackException ex) {
                        throw new SyntaxError("Trying to call pop on an empty stack! Please check expression.");
                    }
                }
            }
            String result = operandStack.pop();     // pop postfix exp off stack
//check if stack is empty. If it is, return result
            if(operandStack.empty()) {
                return result;
            } else { // else throw new exception
                throw new SyntaxError("Stack isn't empty! Please check expression.");
            }

        } else { //will add empty string to stack without this
            throw new SyntaxError("Please enter something!");
        }
    } // end fromPrefixToPostfix

    //converts a postfix exp to prefix
    public static String fromPostfixToPrefix(String expression) throws IOException, SyntaxError {
        if(!expression.equals("")) {
//tokenize the string and create stack
            List<String> expressionToArray = tokenizeExpression(expression);
            Stack<String> operandStack = new Stack<>();
//loop through the expression array and check for operands. If there are operands, push onto stack
            for(String token : expressionToArray) {
                if(!isOperator(token)) {
                    operandStack.push(token + " ");
                } else { // if there are operands, push two operands off the stack and create a
                    // string with the operator followed by two operands
                    try {
                        String operandTwo = operandStack.pop();
                        String operandOne = operandStack.pop();
                        String innerExpression = token + " " + operandOne + operandTwo;
                        operandStack.push(innerExpression);     // push onto stack
                    } catch(EmptyStackException ex) {
                        throw new SyntaxError("Trying to call pop on an empty stack! Please check expression.");
                    }
                }
            }
            String result = operandStack.pop();     // pop prefix exp off stack
//check if stack is empty. If it is, return result
            if(operandStack.empty()) {
                return result;
            } else { // else throw new exception
                throw new SyntaxError("Stack isn't empty! Please check expression.");
            }
        } else { //will add empty string to stack without this
            throw new SyntaxError("Please enter something!");
        }
    } // end fromPostfixToPrefix


    //takes a String and tokenizes it into an ArrayList of ints, chars, and Strings
    private static List<String> tokenizeExpression(String expression) throws IOException {
        StreamTokenizer tokenizeExpression = new StreamTokenizer(new StringReader(expression));
//treat the following as normal chars
        tokenizeExpression.ordinaryChar('-');
        tokenizeExpression.ordinaryChar('/');
        List<String> tokenList = new ArrayList<>();// can also store as objects and cast
//match tokens until end of stream
        while(tokenizeExpression.nextToken() != StreamTokenizer.TT_EOF) {
//number
            if(tokenizeExpression.ttype == StreamTokenizer.TT_NUMBER) {
                tokenList.add(String.valueOf((int) tokenizeExpression.nval));
//if for some reason there are words
            } else if(tokenizeExpression.ttype == StreamTokenizer.TT_WORD) {
                tokenList.add(tokenizeExpression.sval);
            } else { //operator
                tokenList.add(String.valueOf((char) tokenizeExpression.ttype));
            }
        }
        return tokenList;
    } // end tokenizeExpression

    //takes a String and checks the first element and compares
// against cases of known operators
    private static boolean isOperator(String term) {
        switch(term.charAt(0)) { //also looks at the first operand in inner expressions
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    } // end isOperator
} // end class Convert
