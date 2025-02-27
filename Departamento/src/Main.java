public class Main {
    public static void main(String[] args) {

       Department department = new Department();

        department.AddStudent("Astrid", "Martinez",40);
        department.AddStudent("Fernando", "Gonzales",20);
        department.AddStudent("Griselda", "Lopez",40);
        department.AddStudent("Marta", "Garcia",40);
        department.AddStudent("Horacio", "Gonzales",40);

        department.PrintStudent();
    }
}