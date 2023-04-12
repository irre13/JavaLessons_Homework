package lesson6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private int id;
    int age;
    String firstName;
    String species;
    String male;
    String lastVisit;

/*    public Cat(int id, int age, String firstName, String species, String male, String lastVisit) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.species = species;
        this.male = male;
        this.lastVisit = lastVisit;
    }*/

    public Cat(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id && age == cat.age && Objects.equals(firstName, cat.firstName) && Objects.equals(species, cat.species) && Objects.equals(male, cat.male) && Objects.equals(lastVisit, cat.lastVisit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, firstName, species, male, lastVisit);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %d",id, firstName, species, male, age);


    }

    void print() {
        if (firstName.equals("Лев Толстой")) {
            System.out.println(this);
        }
    }

/*    @Override
    public boolean equals(Object o) {
        var t = (Cat) o;
        return id == t.id && firstName == t.firstName;
    }

    @Override
    public int hashCode() {
        return id;
    }*/

    public int getId() {
        return id;
    }

/*    public void setId(int id) {
        this.id = id;
    }*/
}


