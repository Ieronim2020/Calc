package by.tms.service;

public class Calculated {
    public String addition(double x, double y) {
        return String.format("%.2f + %.2f = %.2f", x, y, x + y);
    }

    public String diminution(double x, double y) {
        return String.format("%.2f - %.2f = %.2f", x, y, x - y);
    }

    public String multiplication(double x, double y) {
        return String.format("%.2f * %.2f = %.2f", x, y, x * y);
    }

    public String division(double x, double y) throws ArithmeticException {
        return String.format("%.2f / %.2f = %.2f", x, y, x / y);
    }
}