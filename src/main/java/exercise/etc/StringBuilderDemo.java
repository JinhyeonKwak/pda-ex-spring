package exercise.etc;

import java.util.Scanner;

public class StringBuilderDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        String str1 = scanner.next();
        String str2 = scanner.next();

        stringBuilder.append(str1);
        stringBuilder.append(str2);

        System.out.println(stringBuilder.toString());
    }
}
