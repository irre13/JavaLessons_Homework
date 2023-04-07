package lesson5;

import java.util.*;

public class HomeworkLesson5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания для проверки (1,2 или 3: )");
        int num = scan.nextInt();
        switch (num) {
            case 1 -> exerciseOne();
//            case 2 -> exerciseTwo();
//            case 3 -> exersiseThree();
            default -> System.out.println("Введен неверный номер");
        }
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
                        System.out.printf("%s был удален\n",  item);
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

        private static void showAll (Map < String, String > hm){
            if (!hm.isEmpty()) {
                for (var item : hm.entrySet()) {
                    System.out.printf("%s : %s\n", item.getValue(), item.getKey());
                }
            } else System.out.println("Список пуст\n ============");
        }

        private static Map<String, String> newRecord (Map < String, String > hm){
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

        private static void menu(){
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
