package practice10;

public class Student extends Person{
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce(){
        String introduce = ((this.equals(klass.getLeader())) ? "I am Leader of Class 2." : "I am at Class 2.");
        return super.introduce() + " I am a Student. " + introduce;
    }
}
