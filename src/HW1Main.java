import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HW1Main {
    private static Admin admin = new Admin("admin", "one", "Admin", "Admin001");;
    private static Student student;

    public static void main(String[] args)throws ClassNotFoundException, FileNotFoundException, IOException {
        File f = new File("Data.dat");
        if(!f.exists()){
            Data.readCourseCSV("src/MyUniversityCourses.csv");
            firstLoginPage();
        }
        else{
            Data.retrieveList(f);
            generalLoginPage();
        }
        System.out.println();
    }

    public static void firstLoginPage(){
        System.out.println("Only Admin can log in.");
        loginAdminPage();
        System.out.println("Must create a student first.");
        adminCourseManagement();
    }

    public static void generalLoginPage(){
        System.out.println("1.Admin   2. Student   Type number to choose your identity");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if(s.equals("1")){
            loginAdminPage();
            adminCourseManagement();
        }
        else if(s.equals("2")){
            loginStudentPage();
            studentReportsInterface();
        }
    }

    public static void loginAdminPage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = scan.nextLine();
        System.out.println("Enter Password");
        String password = scan.nextLine();
        if(!(admin.getUserName().equals(username) && admin.getPassword().equals(password))){
            loginAdminPage();
        }
    }

    public static void adminCourseManagement(){
        Scanner scan = new Scanner(System.in);
        System.out.println("This is your Course Management menu. Type the number to proceed.");
        System.out.println("1.Create a new course");
        System.out.println("2.Delete a course");
        System.out.println("3.Edit a course");
        System.out.println("4.Display information for a given course");
        System.out.println("5.Register a student");
        System.out.println("6.Go to Report Menu.");
        System.out.println("7.Exit");
        String s = scan.nextLine();
        if (s.equals("1")) {
            admin.createCourse();
            adminCourseManagement();
        }
        else if(s.equals("2")){
            admin.deleteCourse();
            adminCourseManagement();
        }
        else if(s.equals("3")){
            admin.editCourse();
            adminCourseManagement();
        }
        else if(s.equals("4")) {
            admin.displayCourse();
            adminCourseManagement();
        }
        else if(s.equals("5")) {
            admin.createStudent();
            adminCourseManagement();
        }
        else if(s.equals("6")) {
            adminReportsInterface();
        }
        else if(s.equals("7")) {
            admin.exit();
            generalLoginPage();
        }
        else{
            System.out.println("Wrong operation. Please choose again.");
        }
    }

    public static void adminReportsInterface(){
        Scanner scan = new Scanner(System.in);
        System.out.println("This is your report menu. Type the number to proceed.");
        System.out.println("1.View all courses");
        System.out.println("2.View all courses that are FULL");
        System.out.println("3.Write to a file the list of course that are Full");
        System.out.println("4.View the names of the students being registered in a specific course");
        System.out.println("5.View the list of courses that a given student is being registered on");
        System.out.println("6.Sort the course list");
        System.out.println("7.Go to Course Management Menu");
        System.out.println("8.Exit");
        String s = scan.nextLine();
        if(s.equals("1")) {
            admin.viewAllCourse();
            adminReportsInterface();
        }
        else if(s.equals("2")) {
            admin.viewFullCourse();
            adminReportsInterface();
        }
        else if(s.equals("3")) {
            admin.writeFullCourseFile();
            adminReportsInterface();
        }
        else if(s.equals("4")) {
            admin.viewStudentList();
            adminReportsInterface();
        }
        else if(s.equals("5")) {
            admin.viewStudentAllCourse();
            adminReportsInterface();
        }
        else if(s.equals("6")) {
            admin.sortCourse();
            adminReportsInterface();
        }
        else if(s.equals("7")) {
            adminCourseManagement();
        }
        else if(s.equals("8")) {
            admin.exit();
            generalLoginPage();
        }
        else {
            System.out.println("Wrong Operation. Please choose again.");
        }
    }

    public static void loginStudentPage(){
        ArrayList<Student> stu = Data.getStudentList();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = scan.nextLine();
        System.out.println("Enter Password");
        String password = scan.nextLine();
        for(Student s : stu){
            if(!(s.getUserName().equals(username) && s.getPassword().equals(password))){
                loginStudentPage();
            }
            student = s;
        }

    }

    public static void studentReportsInterface(){
        Scanner scan = new Scanner(System.in);
        System.out.println("This is your report menu. Type the number to proceed.");
        System.out.println("1.View all courses");
        System.out.println("2.View all courses that are not FULL");
        System.out.println("3.Register on a course");
        System.out.println("4.Withdraw from a course");
        System.out.println("5.View all courses that the current student is being registered in");
        System.out.println("6.Exit.");
        String s = scan.nextLine();
        if(s.equals("1")){
            student.viewAllCourse();
            studentReportsInterface();
        }
        else if(s.equals("2")){
            student.viewNotFullCourse();
            studentReportsInterface();
        }
        else if(s.equals("3")){
            student.registerCourse();
            studentReportsInterface();
        }
        else if(s.equals("4")){
            student.withdrawCourse();
            studentReportsInterface();
        }
        else if(s.equals("5")){
            student.viewMyCourse();
            studentReportsInterface();
        }
        else if(s.equals("6")) {
            student.exit();
            generalLoginPage();
        }
        else{
            System.out.println("Wrong operation. Please choose again.");
        }
    }
}
