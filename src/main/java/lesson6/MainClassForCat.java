package lesson6;

public class MainClassForCat {
    public static void main(String[] args) {
        Cat cat1 = new Cat(10);
        cat1.firstName = "Барсик";
        cat1.species = "British";
        cat1.male = "male";
        cat1.lastVisit = "12.04.2023";
        cat1.age = 2;

        Cat cat2 = new Cat(20);
        cat2.firstName = "Мурка";
        cat2.species = "Notspecies";
        cat2.male = "female";
        cat2.lastVisit = "10.04.2023";
        cat2.age = 1;
        System.out.println(cat2.getId());

        Cat cat3 = new Cat(30, 5, "Борис","Gray",  "male", "20230316" );
        System.out.println(cat3.getFirstName());


        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);

    }
}
