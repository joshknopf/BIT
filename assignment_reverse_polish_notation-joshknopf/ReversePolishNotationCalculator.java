import java.util.*;

/**
 * Josh Knopf
 * BIT 143
 * 2022 Spring
 * Reverse Polish Notation Calculator (Assignment 4)
 * This program reads a Reverse Polish Notation mathematical Expression and
 * evaluates it. The program will show each step if the user chooses that
 * otherwise the program will only print out the end result
 */

public class ReversePolishNotationCalculator {
    // This gets the remainder of the input out of the Scanner
    // prints that remaining input (and also prints out the current contents of the
    // stack)
    // and then re-loads the remaining input into a new Scanner
    // This means that we can keep Scanning the remainder of the input
    private static Scanner printRemainingExpression(Stack<Double> numbers, Scanner scExpression) {

        String remainderOfExpr = scExpression.nextLine();
        System.out.println("Remaining expression: " + remainderOfExpr + " Stack: " + numbers);
        scExpression.close();
        return new Scanner(remainderOfExpr + "\n");
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        char evalAgain = 'y';

        ShouldWeTryAgain: while (evalAgain == 'y') { // Repeats as long as the user wants to do more expressions
            Stack<Double> numStack = new Stack<>();
            char operator = ' ';

            System.out.println("\nRPN calculator");
            System.out.println("\tSupported operators: + - * /");
            System.out.print("Type your RPN expression in so that it can be evaluated: ");
            String rpnExpr = keyboard.nextLine();

            boolean explain = false;
            System.out.print(
                    "Would you like me to explain how to expression is evaluated? (y or Y for yes, anything else means no) ");
            String szExplain = keyboard.nextLine().trim().toLowerCase();
            if (szExplain.length() == 1 && szExplain.charAt(0) == 'y') {
                System.out.println("We WILL explain the evaluation, step by step");
                explain = true;
            }

            Scanner scExpr = new Scanner(rpnExpr + "\n");
            while (scExpr.hasNext()) { // Repeat the following while there's another token left in the Scanner:
                if (explain) {
                    scExpr = printRemainingExpression(numStack, scExpr);
                }
                if (scExpr.hasNextDouble()) { // Used for any number in the scanner
                    double addNum = scExpr.nextDouble();
                    numStack.add(addNum);
                    if (explain) {
                        System.out.println("\tPushing " + addNum + " onto the stack of operands (numbers)");
                    }

                } else { // Used for anything other than a number
                    if (scExpr.hasNext()) {
                        String tempOperator = scExpr.next().trim();
                        if (tempOperator.length() > 1) {
                            System.err.println(
                                    "ERROR! Operator (non-numeric input) contains more than 1 character: "
                                            + tempOperator);
                            System.out.println(
                                    "Since we can't evaluate that expression we'll ask you for another one to evaluate instead");
                            continue ShouldWeTryAgain;
                        } else {
                            operator = tempOperator.charAt(0);
                        }
                    }
                    if (numStack.isEmpty()) {
                        System.err.println(
                                "ERROR! Expected to find 2 operands (numbers) but we don't have any numbers on the stack!");
                        System.out.println(
                                "Since we can't evaluate that expression we'll ask you for another one to evaluate instead");
                        continue ShouldWeTryAgain;
                    }
                    double operand2 = numStack.pop();
                    if (numStack.isEmpty()) {
                        System.err.println(
                                "ERROR! Expected to find 2 operands (numbers) but we don't have a second number on the stack!");
                        System.out.println(
                                "Since we can't evaluate that expression we'll ask you for another one to evaluate instead");
                        continue ShouldWeTryAgain;
                    }
                    double operand1 = numStack.pop();
                    double total = 0.0;
                    switch (operator) {
                        default:
                            System.err.println("ERROR! Operator not recognized: " + operator);
                            System.out.println(
                                    "Since we can't evaluate that expression we'll ask you for another one to evaluate instead");
                            continue ShouldWeTryAgain;
                        case '+':
                            total = operand1 + operand2;
                            numStack.add(total);
                            break;
                        case '-':
                            total = operand1 - operand2;
                            numStack.add(total);
                            break;
                        case '*':
                            total = operand1 * operand2;
                            numStack.add(total);
                            break;
                        case '/':
                            total = operand1 / operand2;
                            numStack.add(total);
                            break;
                    }
                    if (explain) {
                        System.out.println("\tPopping " + operand1 + " and " + operand2 + " then applying "
                                + operator + " to them, then pushing the result back onto the stack");
                    }
                }
            }
            // Print final results or errors that come up after running through everything
            // in the scanner.
            if (numStack.size() > 1) {
                System.err.println("ERROR! Ran out of operators before we used up all the operands (numbers):");
                while (!numStack.isEmpty()) {
                    System.err.println("\t" + numStack.pop());
                }
            }
            if (rpnExpr.trim().length() == 0) {
                System.err.println("ERROR! Ran out of operands (numbers)");
            }
            if (numStack.size() == 1) {
                System.out.println("END RESULT: " + numStack.pop());
            }
            System.out
                    .print("\nWould you like to evaluate another expression? (y or Y for yes, anything else to exit) ");
            String repeat = keyboard.nextLine().trim().toLowerCase();
            if (repeat.length() == 1 && repeat.charAt(0) == 'y')
                evalAgain = 'y';
            else
                evalAgain = 'n';
        }
        System.out.println("Thank you for using RPN Calculator!");
    }
}