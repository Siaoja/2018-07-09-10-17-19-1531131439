package practice08;

public class Student extends Person{
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce(){
        String introduce = ((klass.getLeader().getId() == this.getId()) ? "I am Leader of Class 2." : "I am at Class 2");
        return super.introduce() + " I am a Student. " + introduce;
    }

}
