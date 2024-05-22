package exercise.exception;

import java.util.Scanner;

public class InputMismatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("점수를 입력하세요.");
            String input = scanner.nextLine();

            if (input.equals("q"))
                break;

            try {
                // inputMismatchEx

                int score = Integer.parseInt(input);

                if (score >= 60)
                    System.out.println("합격입니다.");
                else
                    System.out.println("다음에 다시 봐요.");
            } catch (NumberFormatException e) {
                // 잘못된 문자열을 숫자로 형 변환할 때 발생하는 예외 클래스
                System.out.println("NumberFormatException");
            }
        }

        System.out.println("프로그램 종료");
        scanner.close();
    }
}
