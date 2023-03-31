package lesson3;

import java.util.*;
import java.util.stream.Collectors;


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
        List<Integer> listNumbers = getNewRandomList(20);
        System.out.println(listNumbers);
        listNumbers.removeIf(num -> num % 2 == 0);
        System.out.println(listNumbers);
    }

    private static List<Integer> getNewRandomList(int size) {
        List<Integer> listInt = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            listInt.add(random.nextInt(100));
        }
        return listInt;
    }

    private static double getAverage(List<Integer> list) {
        IntSummaryStatistics stats = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        return stats.getAverage();
    }

    private static void exerciseTwo() {
        List<Integer> ArrayList = getNewRandomList(10);
        System.out.println(ArrayList);
        int max = Collections.max(ArrayList);
        int min = Collections.min(ArrayList);
        double avg = getAverage(ArrayList);
        System.out.printf("Максимальное: %d, минимальное: %d, среднее значение: %.1f", max, min, avg);
    }


    private static void exerciseThree() {
        List<String> planetsNames = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto");
        Random random = new Random();
        List<String> listPlanet = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            listPlanet.add(planetsNames.get(random.nextInt(9)));
        }
        List<String> listWithoutDuplicates = listPlanet.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
    }


    private static void exerciseFour() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "2", "3", "b", "c", "45", "df", "1"));
        for (int i = 0; i < list.size(); i++) {
            try {
                Integer.parseInt(list.get(i));
                list.remove(list.get(i));
                i--;
            } catch (NumberFormatException ignored) {
            }
        }
        System.out.println(list);
    }
}
