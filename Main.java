package Student;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while(true) {

            System.out.println("\n1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Update Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    dao.addStudent(
                        new Student(id,name,email,course)
                    );
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(uid,newCourse);
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int did = sc.nextInt();

                    dao.deleteStudent(did);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}