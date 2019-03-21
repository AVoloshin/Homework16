import java.util.ArrayList;

public class Person {
    public String name;
    public int age;
    public boolean isStudent;
    public Wife wife;
    public ArrayList <String> pet;

    public Person(String name, int age, boolean isStudent, Wife wife, ArrayList<String> pet) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
        this.wife = wife;
        this.pet = pet;
    }

    public Person() {
    }
}