import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Department {


    static ArrayList <Department> studentsMarks = new ArrayList<Department>();
    static Map<Student, Integer> mapStudents = new HashMap<Student, Integer>();
    Student student;
    Integer mark;

    public Department(Integer mark, Student student) {
        this.mark = mark;
        this.student = student;
    }
    public Department() {

    }


    public void PrintStudent(){
        Iterator it = mapStudents.keySet().iterator();
        while(it.hasNext()){
            Student key = (Student) it.next();
            System.out.println(" " + key.name + " "+key.lastName+" -> " + mapStudents.get(key));
        }
    }

    public boolean AddStudent(String name, String lastName, Integer mark){
        Student student = new Student(name, lastName);
        System.out.println(student.name+" " + mark);
        mapStudents.put(student, mark);
        int index=StudentExists(lastName);
        if(index>=0){
            studentsMarks.add(index, new Department( mark, student));
            return  true;
        }
        return false;
    }

    // veroifica si un estudiante existe ya en el listado de estudiantes
    private int StudentExists(String lastName){
        Iterator it = mapStudents.keySet().iterator();
        Integer number=0;
        while(it.hasNext()){
            Student key = (Student) it.next();
            if(key.lastName.toLowerCase().equals(lastName.toLowerCase()) ){
                return number;
            }
            number++;
        }
        return -1;
    }


}
