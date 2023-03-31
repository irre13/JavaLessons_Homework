package lesson3;

import java.util.Scanner;

public class HomeworkLessonThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания для проверки (1, 2, 3 или 4: )");
        int num = scan.nextInt();
        switch (num) {
            case 1 -> exerciseOne();
            case 2 -> exerciseTwo();
            case 3 -> exerciseThree();
            case 4 -> exerciseFour();
            default -> System.out.println("Введен неверный номер");
        }
    }

    private static void exerciseOne() {
    }


    private static void exerciseTwo() {

    }



    private static void exerciseThree() {

    }



    private static void exerciseFour() {
    }
}
