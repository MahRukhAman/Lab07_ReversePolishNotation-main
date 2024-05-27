package postfix;

import stack.Underflow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Infix infixConverter = new Infix();
        Postfix postfixEvaluator = new Postfix();

        System.out.print("Enter an infix expression: ");
        String infix = scanner.nextLine();

        try {
            String postfix = infixConverter.toPostfix(infix);
            double result = postfixEvaluator.evaluate(postfix);
            System.out.println("Postfix: " + postfix);
            System.out.println("Result: " + result);
        } catch (Underflow e) {
            System.err.println("Error: Stack underflow occurred.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
