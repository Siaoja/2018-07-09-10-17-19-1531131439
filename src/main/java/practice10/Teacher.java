package practice10;


import java.util.LinkedList;

public class Teacher extends Person{
    LinkedList<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce(){
        StringBuffer relationWithClass = new StringBuffer();
        relationWithClass.append("I teach ");
        if(classes != null && classes.size() != 0){
            relationWithClass.append("Class ");
            for(Klass klass : classes){
                relationWithClass.append(klass.getNumber()+", ");
                System.out.println(relationWithClass.length());
            }
            relationWithClass.replace(relationWithClass.length()-2,relationWithClass.length(),".");
        }else{
            relationWithClass.append("No Class.");
        }
        return super.introduce() + " I am a Teacher. " + relationWithClass;
    }

    public String introduceWith(Student student){
        StringBuffer relationWithStudent = new StringBuffer();
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
}
