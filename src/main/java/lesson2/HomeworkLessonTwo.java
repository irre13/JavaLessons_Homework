package lesson2;

import java.io.*;
import java.util.Scanner;

public class HomeworkLessonTwo {
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
        System.out.print("Введите строку: ");
        String inputString = scan.nextLine();
        System.out.println(isPalindromeUsingStringBuilder(inputString));
    }

    public static boolean isPalindromeUsingStringBuilder(String text) {
        String clean = text.toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }

    private static void exerciseTwo() {
        StringBuilder sb = makeNewString();
        String pathDir = "src/main/java/lesson2/FileFromExsTwo.txt";
        try {
            writeFile(pathDir, sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static StringBuilder makeNewString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TEST".repeat(100));
        return sb;
    }

    private static void writeFile(String pathDir, StringBuilder str) throws IOException {
        FileWriter file = new FileWriter(pathDir);
        PrintWriter pw = new PrintWriter(file);
        pw.print(str);
        pw.close();
    }

    private static void exerciseThree() {
        String pathDir = "src/main/java/lesson2/testDir";
        String[] dirListNames = readDir(pathDir);
        int count = 1;
        for (String fileName :
                dirListNames) {
            String expans = "";
            String[] arr = fileName.split("\\.");
            if (arr.length > 1) expans = arr[1];
            System.out.printf("%d Расширение файла '%s' : %s \n",count,fileName,expans);
            count++;
        }
    }

    private static String[] readDir(String pathDir) {
        File directoryPath = new File(pathDir);
        return directoryPath.list();
    }
}
