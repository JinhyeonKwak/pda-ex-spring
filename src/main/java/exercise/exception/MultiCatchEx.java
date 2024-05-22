package exercise.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiCatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cards = {4, 5, 6, 1, 2, 3};

        try {
            System.out.println("몇번째 카드를 뽑으실래요?");
            int cardIdx = scanner.nextInt();

            System.out.println("뽑은 카드 번호는 : " +
                    cardIdx);
            System.out.println("뽑은 카드에 적힌 숫자는 : " +
                    cards[cardIdx]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("그거.. 없는 번호야..");
        } catch (InputMismatchException e) {
            System.out.println("야.. 숫자만 입력하라고..");
        }
    }
}
