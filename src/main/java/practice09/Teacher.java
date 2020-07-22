package practice09;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce(){
        String relationWithClass = " I teach " + ((this.klass!=null)? this.klass.getDisplayName() + ".":"No Class.");
        return super.introduce() + " I am a Teacher." + relationWithClass;
    }

    public String introduceWith(Student student){
        String relationWithStudent = ((student.getKlass().getNumber() == this.klass.getNumber()) ? "I teach ":"I don't teach ") + student.getName() + ".";
        return  super.introduce() + " I am a Teacher. " + relationWithStudent;
    }
}
