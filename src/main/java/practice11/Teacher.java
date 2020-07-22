package practice11;


import java.util.LinkedList;

public class Teacher extends Person implements KlassListener{
    LinkedList<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        buildKlassListener(classes);
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce(){
        StringBuilder relationWithClass = new StringBuilder();
        relationWithClass.append("I teach ");
        if(classes != null && classes.size() != 0){
            relationWithClass.append("Class ");
            for(Klass klass : classes){
                relationWithClass.append(klass.getNumber()).append(", ");
                System.out.println(relationWithClass.length());
            }
            relationWithClass.replace(relationWithClass.length()-2,relationWithClass.length(),".");
        }else{
            relationWithClass.append("No Class.");
        }
        return super.introduce() + " I am a Teacher. " + relationWithClass;
    }

    public String introduceWith(Student student){
        StringBuilder relationWithStudent = new StringBuilder();
        if(classes != null && classes.size() != 0){
            for(Klass klass : classes){
                if(klass.isIn(student)){
                    relationWithStudent.append(String.format("I teach %s.",student.getName()));
                }
            }
        }
        if(!(relationWithStudent.length() > 0)){
            relationWithStudent.append(String.format("I don't teach %s.",student.getName()));
        }
        return  super.introduce() + " I am a Teacher. " + relationWithStudent;
    }

    public boolean isTeaching(Student student){
        boolean isTeaching = false;
        for(Klass klass : classes){
            if(klass.isIn(student)){
                isTeaching = true;
                break;
            }
        }
        return isTeaching;
    }

    public void buildKlassListener(LinkedList<Klass> classes){
        for(Klass klass : classes){
            klass.registerKlassListener(this);
        }
    }

    @Override
    public void joinStatement(Student student) {
        System.out.print(String.format("I am %s. I know %s has joined Class %s.\n",this.getName(),student.getName(),student.getKlass().getNumber()));
    }

    @Override
    public void becomeLeaderStatement(Student student) {
        System.out.print(String.format("I am %s. I know %s become Leader of Class %s.\n",this.getName(),student.getName(),student.getKlass().getNumber()));
    }
}
