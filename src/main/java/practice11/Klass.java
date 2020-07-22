package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private final int number;
    private Student leader;
    private List<KlassListener> klassListeners;

    public Klass(int number) {
        this.number = number;
        klassListeners = new ArrayList<>();
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
            notifyBecomeLeader(student);
        }else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student){
        student.setKlass(this);
        notifyJoin(student);
    }

    public boolean isIn(Student student){
        return student.getKlass().number == this.number;
    }

    public void registerKlassListener(KlassListener klassListener){
        klassListeners.add(klassListener);
    }

    public void notifyJoin(Student student){
        for(KlassListener klassListener : klassListeners){
            klassListener.joinStatement(student);
        }
    }
    public void notifyBecomeLeader(Student student){
        for(KlassListener klassListener : klassListeners){
            klassListener.becomeLeaderStatement(student);
        }
    }
}
