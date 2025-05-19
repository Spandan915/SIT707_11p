package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result.
     *
     * @param number1
     * @param number2
     * @return result of the addition, or NaN if inputs are invalid
     */
    public static double q1Addition(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 + num2;
        } catch (NumberFormatException e) {
            // Invalid input, return NaN
            return Double.NaN;
        }
    }

    /**
     * Calculate Q2 result.
     *
     * @param number1
     * @param number2
     * @return result of the subtraction, or NaN if inputs are invalid
     */
    public static double q2Subtraction(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 - num2;
        } catch (NumberFormatException e) {
            // Invalid input, return NaN
            return Double.NaN;
        }
    }

public static double q3Multiplication(String number1, String number2) {
    try {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        return num1 * num2;
    } catch (NumberFormatException e) {
        // Invalid input, return NaN
        return Double.NaN;
    }
}
}