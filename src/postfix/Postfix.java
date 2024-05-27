package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

public class Postfix {

	public double evaluate(String postfix) throws Underflow {
		Stack<Double> stack = new LinkedListStack<>();
		String[] tokens = postfix.split(" ");

		for (String token : tokens) {
			if (token.matches("\\d+")) {
				stack.push(Double.valueOf(token));
			} else if (isOperator(token.charAt(0))) {
				double b = stack.pop();
				double a = stack.pop();
				double result = applyOperator(token.charAt(0), a, b);
				stack.push(result);
			}
		}

		return stack.pop();
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
	}

	private double applyOperator(char operator, double a, double b) {
		switch (operator) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				return a / b;
			case '^':
				return Math.pow(a, b);
			default:
				throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
}
