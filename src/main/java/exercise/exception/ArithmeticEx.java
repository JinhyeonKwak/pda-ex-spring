package exercise.exception;

public class ArithmeticEx {
    public static void main(String[] args) {
        int result = divide(10, 0);
    }

    public static int divide(int x, int y) {
        int result = 0;

        try {
            result = x / y;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없다.");
        }

        return result;
    }
}
