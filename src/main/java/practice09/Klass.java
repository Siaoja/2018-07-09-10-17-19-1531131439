package practice09;


public class Klass {
    private int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public String getDisplayName(){
        return "Class " + number;
    }

    public void assignLeader(Student student){
        if(this.number == student.getKlass().getNumber()){
            leader = student;
        }else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student){
        student.setKlass(this);
    }
}
