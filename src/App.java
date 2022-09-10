import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class App {

    public static double calculate(String sum) {

        // trim space and bracket at prefix and suffix
        String expr = sum.trim();
        if (expr.startsWith("(") && expr.endsWith(")")) {
            expr = expr.substring(1, expr.length() - 1).trim();
        }

        // convert the expression to be solved into array
        String[] exprArr = expr.split(" ");
        List<String> toSolve = new ArrayList<>();

        // process the bracket
        Stack<Integer> bracketIdx = new Stack<>();
        for (int i = 0; i < exprArr.length; i++) {
            String item = exprArr[i];
            toSolve.add(item);
            if ("(".equals(item)) {
                bracketIdx.push(i);
            } else if (")".equals(item)) {
                int openIdx = bracketIdx.pop();
                List<String> toEval = toSolve.subList(openIdx, toSolve.size());
                double solved = calculate(String.join(" ", toEval));
                toEval.clear();
                toSolve.add(String.valueOf(solved));
            }
        }

        // handle multiplication and division
        Queue<String> inProcess = new LinkedList<>();
        String operator = null;
        BigDecimal left = null;
        for (String num: toSolve) {
            try {
                BigDecimal operand = new BigDecimal(num);
                if (left == null) {
                    left = operand;
                } else {
                    if ("*".equals(operator)) {
                        left = left.multiply(operand);
                    } else if ("/".equals(operator)) {
                        left = left.divide(operand);
                    } else {
                        inProcess.add(left.toPlainString());
                        inProcess.add(operator);
                        left = operand;
                    }
                }
            } catch (NumberFormatException e) {
                operator = num;
            }
        }
        inProcess.add(left.toPlainString());

        // handle addition and substraction
        BigDecimal result = BigDecimal.ZERO;
        operator = "+";
        while (!inProcess.isEmpty()) {
            String elem = inProcess.remove();
            try {
                BigDecimal value = new BigDecimal(elem);
                if ("+".equals(operator)) {
                    result = result.add(value);
                } else if ("-".equals(operator)) {
                    result = result.subtract(value);
                }
            } catch (NumberFormatException e) {
                operator = elem;
            }
        }

        return result.doubleValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Solve below arithmetic: \n");

        String q1 = "1 + 1";
        System.out.println(q1);
        System.out.println("Expected: 2.0 -> result: " + calculate(q1) + "\n");

        String q2 = "2 * 2";
        System.out.println(q2);
        System.out.println("Expected: 4.0 -> result: " + calculate(q2) + "\n");

        String q3 = "1 + 2 + 3";
        System.out.println(q3);
        System.out.println("Expected: 6.0 -> result: " + calculate(q3) + "\n");

        String q4 = "6 / 2";
        System.out.println(q4);
        System.out.println("Expected: 3.0 -> result: " + calculate(q4) + "\n");

        String q5 = "11 + 23";
        System.out.println(q5);
        System.out.println("Expected: 34.0 -> result: " + calculate(q5) + "\n");

        String q6 = "11.1 + 23";
        System.out.println(q6);
        System.out.println("Expected: 34.1 -> result: " + calculate(q6) + "\n");

        String q7 = "1 + 1 * 3";
        System.out.println(q7);
        System.out.println("Expected: 4.0 -> result: " + calculate(q7) + "\n");

        String q8 = "( 11.5 + 15.4 ) + 10.1";
        System.out.println(q8);
        System.out.println("Expected: 37.0 -> result: " + calculate(q8) + "\n");

        String q9 = "23 - ( 29.3 - 12.5 )";
        System.out.println(q9);
        System.out.println("Expected: 6.2 -> result: " + calculate(q9) + "\n");

        String q10 = "10 - ( 2 + 3 * ( 7 - 5 ) )";
        System.out.println(q10);
        System.out.println("Expected: 2.0 -> result: " + calculate(q10));
    }
}
