package practice07;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce(){
        return super.introduce() + " I am a Teacher. I teach " + ((this.klass!=null)? this.klass.getDisplayName() + ".":"No Class.");
    }

    public String introduceWith(Student student){
        String relationWithStudent = ((student.getKlass().getNumber() == this.klass.getNumber()) ? "I teach ":"I don't teach ") + student.getName() + ".";
        return  super.introduce() + " I am a Teacher. " + relationWithStudent;
    }
}
