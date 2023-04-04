package lesson4;

import java.util.*;


public class HomeworkLessonFour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания для проверки (1 или 2: )");
        int num = scan.nextInt();
        switch (num) {
            case 1 -> exerciseOne();
            case 2 -> exerciseTwo();
            default -> System.out.println("Введен неверный номер");
        }
    }

    private static void exerciseOne() {
        Scanner scan = new Scanner(System.in);
        Deque<String> dequeList = new ArrayDeque<>();
        while (true) {
            System.out.print("Введите строку: ");
            String value = scan.nextLine();
            if (value.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (value.equals("print")) {
                try {
                    Deque<String> dequeNewList = new ArrayDeque<>(dequeList);
                    String firstVol = dequeNewList.pollFirst();
                    String lastVol = dequeNewList.pollLast();
                    dequeNewList.push(lastVol);
                    dequeNewList.add(firstVol);
                    System.out.println(dequeNewList);
                } catch (NullPointerException e) {
                    System.out.println("Не введены строки");
                }
            } else if (value.equals("revert")) {
                try {
                    dequeList.removeLast();
                    System.out.println(dequeList);
                } catch (NoSuchElementException e) {
                    System.out.println("Не введены строки");
                }
            } else {
                dequeList.add(value.trim());
            }
        }
    }


    private static void exerciseTwo() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        System.out.println(intList);
        List<Integer> intListReverse = reverseList(intList);
        System.out.println(intListReverse);
    }


    private static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reverse = new ArrayList<>(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            reverse.add(list.get(i));
        }
        return reverse;
    }
}
