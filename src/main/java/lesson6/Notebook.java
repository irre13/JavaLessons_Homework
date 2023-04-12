package lesson6;

import lombok.Getter;

@Getter
public class Notebook {
    private final int id;
    String brand;
    String model;
    String condition;
    String color;
    int screenSize;
    String modelCPU;
    String modelGPU;
    int amountRAM;
    int amountHUD;
    public Notebook(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(" %s %s" ,brand, model);
    }
}
