package main;



public class Model {
    public static double holdNumber=0;
    public static String holdOperator = "+";
    public static Boolean Flag = false;
    public static double calculate(double number1,double number2, String operator){
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "%":
                return number1 % number2;
        }

        return number1/number2;
    }
}
