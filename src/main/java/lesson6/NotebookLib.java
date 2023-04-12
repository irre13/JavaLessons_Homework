package lesson6;

import java.util.*;

public class NotebookLib {
    public static void main(String[] args) {

        Notebook notebook1 = new Notebook(10);
        notebook1.brand = "Lenono";
        notebook1.model = "IdeaPad 3N";
        notebook1.condition = "new";
        notebook1.color = "Black";
        notebook1.screenSize = 15;
        notebook1.modelCPU = "AMD Ryzen 5 5625U";
        notebook1.modelGPU= "Intel Iris Xe Graphics";
        notebook1.amountRAM = 4;
        notebook1.amountHUD = 256;

        Notebook notebook2 = new Notebook(20);
        notebook2.brand = "Acer";
        notebook2.model = "Nitro 5P4black";
        notebook2.condition = "resale";
        notebook2.color = "Black";
        notebook2.screenSize = 17;
        notebook2.modelCPU = "Intel Core i5";
        notebook2.modelGPU= " NVIDIA GeForce GTX 1650";
        notebook2.amountRAM = 4;
        notebook2.amountHUD = 512;

        Notebook notebook3 = new Notebook(30);
        notebook3.brand = "Xiaomi";
        notebook3.model = "RedmiBook 15";
        notebook3.condition = "new";
        notebook3.color = "Silver";
        notebook3.screenSize = 15;
        notebook3.modelCPU = "Intel Core i5";
        notebook3.modelGPU= "Intel Iris Xe Graphics";
        notebook3.amountRAM = 8;
        notebook3.amountHUD = 512;

        Notebook notebook4 = new Notebook(40);
        notebook4.brand = "Lenono";
        notebook4.model = "IdeaPad 3S";
        notebook4.condition = "resale";
        notebook4.color = "Silver";
        notebook4.screenSize = 15;
        notebook4.modelCPU = "AMD Ryzen 5 5625U";
        notebook4.modelGPU= "Intel Iris Xe Graphics";
        notebook4.amountRAM = 8;
        notebook4.amountHUD = 1024;

        List<Notebook> notebookList = new ArrayList<>();
        notebookList.add(notebook1);
        notebookList.add(notebook2);
        notebookList.add(notebook3);
        notebookList.add(notebook4);

        HashSet<Notebook> hashNotebook = new HashSet<>(notebookList);
        System.out.println("Представленные ноутбуки: ");
        for (var item:
             hashNotebook) {
            System.out.println(item);
        }
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите цифру для просмотра инофоррмации по ноутбуку: ");


        }
    }

}
