public abstract class Human {
    public String name;
}

class Professor extends Human {
    public String exp;
    public String disc;
    public String name;

    public Professor(String name, String exp, String disc) {
        this.name = name;
        this.exp = exp;
        this.disc = disc;
    }
}
class Employee extends Human {
    public String work = "janitor";
    public String name;

    public Employee(String name) {
        this.name=name;
    }
}
class Student extends Human {
    public String kurs;
    public String specs;
    public String name;

    public Student(String name, String kurs, String specs) {
        this.name = name;
        this.kurs = kurs;
        this.specs = specs;
    }
}
