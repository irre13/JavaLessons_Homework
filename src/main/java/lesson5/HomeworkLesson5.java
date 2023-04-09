package lesson5;

import java.util.*;
import java.util.Map.Entry;

public class HomeworkLesson5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания для проверки (1,2 или 3: )");
        int num = scan.nextInt();
        switch (num) {
            case 1 -> exerciseOne();
            case 2 -> exerciseTwo();
            case 3 -> exerciseThree();
            default -> System.out.println("Введен неверный номер");
        }
    }

    private static void exerciseThree() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число (от 1 до 3999): ");
        int num = scan.nextInt();
        if (num > 0 && num < 4000) {
            System.out.printf("Метод 1: %d -----> %s\n", num, numToRoman(num));
            System.out.printf("Метод 2: %d -----> %s", num, getRomanNumber(num));
        } else System.out.println("Введено некоректное число");
    }

    private static String numToRoman(int number) {
        TreeMap<Integer, String> romanNumbers = new TreeMap<>();
        romanNumbers.put(1000, "M");
        romanNumbers.put(900, "DM");
        romanNumbers.put(500, "D");
        romanNumbers.put(400, "CD");
        romanNumbers.put(100, "C");
        romanNumbers.put(90, "XC");
        romanNumbers.put(50, "L");
        romanNumbers.put(40, "XL");
        romanNumbers.put(10, "X");
        romanNumbers.put(9, "IX");
        romanNumbers.put(5, "V");
        romanNumbers.put(4, "IV");
        romanNumbers.put(1, "I");
        int maxKey = romanNumbers.floorKey(number);
        if (number == maxKey) {
            return romanNumbers.get(number);
        }
        return romanNumbers.get(maxKey) + numToRoman(number - maxKey);
    }

    public static String getRomanNumber(int number) {
        return "I".repeat(number)
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }

    private static void exerciseTwo() {
        String[] fullNames = new String[]{
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"
        };
        List<String> listNames = getName(fullNames);
        Map<String, Integer> mapNames = getMap(listNames);
        System.out.println("Повторяющиеся имена: ");
        duplicateNames(mapNames);
        System.out.println("Отсортированный по популярности список имен: ");
        sortNames(mapNames);
    }

    private static void sortNames(Map<String, Integer> map) {
        Map<String, Integer> sortMap = new LinkedHashMap<>();
        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> item : list) {
            sortMap.put(item.getKey(), item.getValue());
        }
        for (var item : sortMap.entrySet()) {
            System.out.printf("%s\n", item.getKey());
        }
    }

    private static void duplicateNames(Map<String, Integer> map) {
        for (var item : map.entrySet()) {
            if (item.getValue() > 1) {
                System.out.printf("%s: %d \n", item.getKey(), item.getValue());
            }
        }
    }

    private static Map<String, Integer> getMap(List<String> list) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String element = list.get(i);
            for (String item : list) {
                if (element.equals(item)) {
                    count++;
                }
            }
            if (!stringIntegerMap.containsKey(element)) {
                stringIntegerMap.put(element, count);
            }
        }
        return stringIntegerMap;
    }

    private static List<String> getName(String[] list) {
        List<String> listNames = new ArrayList<>();
        for (String item : list) {
            String[] listItems = item.split(" ");
            listNames.add(listItems[0]);
        }
        return listNames;
    }

    private static void exerciseOne() {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.putIfAbsent("111", "aaa");
        phoneBook.putIfAbsent("222", "bbb");
        phoneBook.putIfAbsent("333", "ccc");
        while (true) {
            Scanner scan = new Scanner(System.in);
            menu();
            System.out.print("Выберите опцию: ");
            int num = scan.nextInt();
            switch (num) {
                case 1 -> showAll(phoneBook);
                case 2 -> newRecord(phoneBook);
                case 3 -> searchRecord(phoneBook);
                case 4 -> deliteRecord(phoneBook);
                case 0 -> exit();
                default -> System.out.println("Введен неверный номер");
            }
        }
    }

    private static void deliteRecord(Map<String, String> hm) {
        List<String> numbers = searchNumber(hm);
        if (numbers != null) {
            System.out.print("Результат поиска:\n");
            for (var item : numbers) {
                for (var key : hm.keySet()) {
                    if (item.equals(key)) {
                        System.out.printf("%s был удален\n", item);
                        hm.remove(key);
                        break;
                    }
                }
            }
        } else {
            System.out.print("Результат поиска: Контакт не найден\n");
        }
    }

    private static void searchRecord(Map<String, String> hm) {
        List<String> numbers = searchNumber(hm);
        if (numbers != null) {
            System.out.print("Результат поиска:\n");
            for (var item : numbers) {
                for (var key : hm.keySet()) {
                    if (item.equals(key)) {
                        System.out.printf("%s %s\n", hm.get(item), item);
                    }
                }
            }
        } else {
            System.out.print("Результат поиска: Контакт не найден\n");
        }
    }

    private static List<String> searchNumber(Map<String, String> hm) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите имя контакта: ");
        String searchValue = scan.nextLine();
        List<String> contactNumber = new ArrayList<>();
        if (hm.containsValue(searchValue)) {
            for (var key : hm.keySet()) {
                if (searchValue.equals(hm.get(key))) {
                    contactNumber.add(key);
                }
            }
            return contactNumber;
        } else {
            return null;
        }
    }

    private static void showAll(Map<String, String> hm) {
        if (!hm.isEmpty()) {
            for (var item : hm.entrySet()) {
                System.out.printf("%s : %s\n", item.getValue(), item.getKey());
            }
        } else System.out.println("Список пуст\n ============");
    }

    private static Map<String, String> newRecord(Map<String, String> hm) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите имя контакта: ");
        String value = scan.nextLine();
        System.out.print("Выберите номер контакта: ");
        String key = scan.nextLine();
        hm.putIfAbsent(key, value);
        System.out.printf("Контакт добавлен: %s %s\n", hm.get(key), key);
        return hm;
    }

    private static void exit() {
        System.out.println("Пока!");
        System.exit(0);
    }

    private static void menu() {
        System.out.println(
                """
                        Режимы работы:\s
                        1. Вывести телефонный справочник на экран\s
                        2. Добавить запись\s
                        3. Поиск контакта\s
                        4. Удалить запись\s
                        0. Закрыть программу"""
        );
    }
}
