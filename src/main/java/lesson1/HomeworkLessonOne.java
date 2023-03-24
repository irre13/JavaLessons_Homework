package lesson1;

import java.time.LocalTime;
import java.util.*;

public class HomeworkLessonOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания для проверки (1, 2 или 3: )");
        int num = scan.nextInt();
        switch (num) {
            case 1 -> exerciseOne();
            case 2 -> exerciseTwo();
            case 3 -> exerciseThree();
            default -> System.out.println("Введен неверный номер");
        }
    }

    private static void exerciseOne() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int size = scan.nextInt();
        int[] arr;
        arr = getRandomArray(size);
        System.out.println(Arrays.toString(arr));
        IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();
        System.out.printf("Максимальное значение: %d, минимальное значение: %d", stats.getMax(), stats.getMin());
    }

    private static void exerciseTwo() {
        int[] array = new int[]{3, 2, 2, 1, 3, 1};
        int val = 3;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[array.length - i - 1] != val) {
                for (int j = 0; j < array.length / 2; j++) {
                    if (array[j] == 3) {
                        array[j] = array[array.length - i - 1];
                        array[array.length - i - 1] = val;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void exerciseThree() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scan.nextLine();
        LocalTime nowTime = LocalTime.now();
        boolean firstTime = (nowTime.isAfter(LocalTime.of(5, 0))
                && nowTime.isBefore(LocalTime.of(11, 59)));
        boolean secondTime = (nowTime.isAfter(LocalTime.of(12, 0))
                && nowTime.isBefore(LocalTime.of(17, 59)));
        boolean thirdTime = (nowTime.isAfter(LocalTime.of(18, 0))
                && nowTime.isBefore(LocalTime.of(22, 59)));
        boolean fourthTime = (nowTime.isAfter(LocalTime.of(23, 0))
                && nowTime.isBefore(LocalTime.of(4, 49)));
        if (firstTime) {
            System.out.printf("Доброе утро, %s !", name);
        } else if (secondTime) {
            System.out.printf("Добрый день, %s !", name);
        } else if (thirdTime) {
            System.out.printf("Добрый вечер, %s !", name);
        } else if (fourthTime) {
            System.out.printf("Доброй ночи, %s !", name);
        }
    }

    private static int[] getRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
