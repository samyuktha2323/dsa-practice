package dsa2;

import java.util.Scanner;
import java.util.Stack;

class EvaluateReversePolishNotation {
    long resolves(long a, long b, char Operator) {
        if (Operator == '+') return a + b;
        else if (Operator == '-') return a - b;
        else if (Operator == '*') return a * b;
        return a / b;
    }

    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {  // Operator check
                long integer2 = stack.pop();
                long integer1 = stack.pop();
                char operator = tokens[i].charAt(0);
                long resolvedAns = resolves(integer1, integer2, operator);
                stack.push(resolvedAns);
            } else {
                stack.push(Long.parseLong(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();

        System.out.println("Enter the Reverse Polish Notation (tokens separated by space): ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");

        int result = sol.evalRPN(tokens);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
