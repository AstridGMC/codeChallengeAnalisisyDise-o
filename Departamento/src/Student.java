public class Student {
    String name;
    String lastName;

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String StudentToString(Student student){
        return "nombre: "+ student.name+"  apellido: " + student.lastName;
    }


}
