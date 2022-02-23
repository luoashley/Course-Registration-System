import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements CollegeStudent, Serializable {
    private ArrayList<Course> myCourse = new ArrayList<Course>();

    public Student(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
        Data.getStudentList().add(this);
        this.myCourse = new ArrayList<Course>();
    }

    //getter and setter
    public ArrayList<Course> getMyCourse() {return myCourse;}
    public void setMyCourse(ArrayList<Course> myCourse) {this.myCourse = myCourse;}

    //print a student object
    public String studentToString(){
        String studentInfo = getFirstName() + " " + getLastName();
        System.out.println(studentInfo);
        return studentInfo;
    }

    public void viewAllCourse() {
        for(Course c : Data.getCourseList() )
            System.out.println(c);
        System.out.println();
    }

    public void viewNotFullCourse() {
        for(Course c : Data.getCourseList())
            if(c.getCurrentStudents() != c.getMaxStudents())
                System.out.println(c);
    }

    public void registerCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Course Name");
        String courseName = scan.nextLine();
        System.out.println("Please enter Course Section Number");
        String courseSection = scan.nextLine();
        System.out.println("Please enter Full Name");
        String fullName = scan.nextLine();

        for(Course a : Data.getCourseList()){
            if(a.getCourseName().equals(courseName) && a.getCourseSection().equals(courseSection)) {
                a.addStudent(this);
                myCourse.add(a);
            }
        }
    }


    public void withdrawCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Course Name");
        String courseName = scan.nextLine();
        System.out.println("Please enter Course Section Number");
        String courseSection = scan.nextLine();
        System.out.println("Please enter Full Name");
        String fullName = scan.nextLine();
        var names = fullName.split(" ");
        String firstName = names[0];
        String lastName = names[1];

        for(Course a : Data.getCourseList()){
            if(a.getCourseName().equals(courseName) && a.getCourseSection().equals(courseSection)) {
                a.deleteStudent(this);
                myCourse.remove(a);
            }
        }
    }

    public void viewMyCourse(){
        for(Course a : myCourse)
            System.out.println(a);
    }

    public void exit(){
        Data.storeList();
    }
}
