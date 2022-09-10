public class App {

    public static double calculate(String sum) {
        // Your code starts here

        return 0;
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
