import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements Administrator {

    public Admin(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
    }

    //newly created course have no students
    @Override
    public void createCourse(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Course Name");
        String courseName = scan.nextLine();
        System.out.println("Please enter Course ID");
        String courseID = scan.nextLine();
        System.out.println("Please enter Maximum Student Number");
        int maxStudents = Integer.parseInt(scan.nextLine());
        System.out.println("Please enter Course Instructor");
        String courseInstructor = scan.nextLine();
        System.out.println("Please enter Course Section Number");
        String courseSection = scan.nextLine();
        System.out.println("Please enter Course Location");
        String courseLocation = scan.nextLine();

        Data.addCourse(new Course(courseName, courseID, maxStudents, 0, courseInstructor, courseSection, courseLocation));

    }

    @Override
    public void deleteCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Course ID");
        String courseID = scan.nextLine();
        System.out.println("Please enter Course Section Number");
        int courseSection = Integer.parseInt(scan.nextLine());

        for(Course a : Data.getCourseList()){
            if(a.getCourseID().equals(courseID) && a.getCourseSection().equals(courseSection)){
                Data.removeCourse(a);
            }
        }

    }

    //edit a course cannot edit the courseName, courseID, and courseSection because these are basic course Info
    //currentStudents cannot be edited because it reflected the number of student who is currently taking the course.
    //studentList can be edited through other methods like registering a student.
    @Override
    public void editCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Course ID");
        String courseID = scan.nextLine();
        System.out.println("Please enter Course Section Number");
        String courseSection = scan.nextLine();
        System.out.println("Please change Maximum Student Number");
        int maxStudents = Integer.parseInt(scan.nextLine());
        System.out.println("Please change Course Instructor");
        String courseInstructor = scan.nextLine();
        System.out.println("Please change Course Location");
        String courseLocation = scan.nextLine();

        for(Course a : Data.getCourseList()) {
            if (a.getCourseID().equals(courseID) && a.getCourseSection().equals(courseSection)) {
                a.setMaxStudents(maxStudents);
                a.setCourseInstructor(courseInstructor);
                a.setCourseLocation(courseLocation);
            }
        }
    }

    public void displayCourse(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Course ID");
        String courseID = scan.nextLine();
        System.out.println("Please enter Course Section Number");
        int courseSection = Integer.parseInt(scan.nextLine());

        ArrayList<Course> tmp = Data.getCourseList();
        for(Course a : tmp){
                if(a.getCourseID().equals(courseID) && a.getCourseSection().equals(courseSection)) {
                    System.out.println(a);
                    System.out.println("\t " + a.SList());
                }
        }
    }

    @Override
    public void viewAllCourse() {
        for(Course c : Data.getCourseList() ){
            System.out.println(c);
            System.out.print("Student list: ");
            System.out.println("\t " + c.SList());
        }
    }

    @Override
    public void viewFullCourse() {
        for(Course a : Data.getCourseList())
            if(a.getCurrentStudents() == a.getMaxStudents()){
                System.out.println(a);
                System.out.print("Student list: ");
                System.out.println("\t " + a.SList());
            }
        System.out.println();
    }

    @Override
    public void writeFullCourseFile() {
        Data.writeFullCourseFile();
    }

    @Override
    public void viewStudentList() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Course ID");
        String courseID = scan.nextLine();
        System.out.println("Please enter Course Section Number");
        int courseSection = Integer.parseInt(scan.nextLine());

        for(Course a : Data.getCourseList()){
            if(a.getCourseID().equals(courseID) && a.getCourseSection().equals(courseSection)){
                System.out.println(a.SList());
            }
        }

    }

    @Override
    public void viewStudentAllCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter First Name");
        String firstName = scan.nextLine();
        System.out.println("Please enter Last Name");
        String lastName = scan.nextLine();

        for(Student s : Data.getStudentList()){
            if(s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                s.viewMyCourse();
            }
        }
    }

    @Override
    public void sortCourse() {
        Data.sortCourse();
        viewAllCourse();
    }


    @Override
    public void exit() {Data.storeList();}

    public void createStudent(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter First Name");
        String firstName = scan.nextLine();
        System.out.println("Please enter Last Name");
        String lastName = scan.nextLine();
        System.out.println("Please enter Student User Name");
        String userName = scan.nextLine();
        System.out.println("Please enter Student Password");
        String password = scan.nextLine();

        Student s = new Student(firstName,lastName,userName,password);
    }
}
