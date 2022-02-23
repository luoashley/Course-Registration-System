import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    private String courseName;
    private String courseID;
    private int maxStudents;
    private int currentStudents;
    private ArrayList<Student> studentList = new ArrayList<>();
    private String courseInstructor;
    private String courseSection;
    private String courseLocation;
    //Constructor
    public Course(String courseName, String courseID, int maxStudents, int currentStudents, String courseInstructor,
                  String courseSection, String courseLocation){
        this.courseName = courseName;
        this.courseID = courseID;
        this.maxStudents = maxStudents;
        this.currentStudents = currentStudents;
        this.courseInstructor = courseInstructor;
        this.courseSection = courseSection;
        this.courseLocation = courseLocation;
    }

    public void addStudent(Student s){
        studentList.add(s);
        currentStudents++;
    }

    public void deleteStudent(Student s){
        studentList.remove(s);
        currentStudents--;
    }


    //getter and setter
    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {this.courseName = courseName;}
    public String getCourseID() {return courseID;}
    public void setCourseID(String courseID) {this.courseID = courseID;}
    public int getMaxStudents() {return maxStudents;}
    public void setMaxStudents(int maxStudents) {this.maxStudents = maxStudents;}
    public int getCurrentStudents() {return currentStudents;}
    public void setCurrentStudents(int currentStudents) {this.currentStudents = currentStudents;}
    public ArrayList<Student> getStudentList() {return studentList;}
    public void setStudentList(ArrayList<Student> studentList) {this.studentList = studentList;}
    public String getCourseInstructor() {return courseInstructor;}
    public void setCourseInstructor(String courseInstructor) {this.courseInstructor = courseInstructor;}
    public String getCourseSection() {return courseSection;}
    public void setCourseSection(String courseSection) {this.courseSection = courseSection;}
    public String getCourseLocation() {return courseLocation;}
    public void setCourseLocation(String courseLocation) {this.courseLocation = courseLocation;}

    //Helper Method to help admin and student
    //display the info of one course
    public String SList(){
        String answer = "";
        for (Student s : studentList)
            answer = answer + s.getFullName() + " ;";
        return answer;
    }

    @Override
    public String toString(){
        return getCourseName() + " " + getCourseID() + " " + getMaxStudents() + " " +
                getCurrentStudents() + " " + getCourseInstructor() + " " +
                getCourseSection() + " " + getCourseLocation();
    }

    public void deleteStudent(String firstName, String lastName){
        for(Student s : studentList)
            if(s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                studentList.remove(s);
    }

    public void displayStudentList(){
        ArrayList<Student> list = getStudentList();
        for(Student s : list)
            System.out.println(s.studentToString());
    }

}
