package practice09;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String introduce(){
        return "My name is " + name + ". I am " + age + " years old.";
    }

    @Override
    public boolean equals(Object object){
        if(object == null)
            return false;
        else if(this == object || ((Person)object).getId() == this.getId())
            return true;
        return false;
    }
}
