import java.io.IOException;
import java.util.ArrayList;

public interface Administrator {
    //Admin class will implement this interface

    void createCourse();
    void deleteCourse();
    void editCourse();
    void displayCourse();
    void createStudent();

    void viewAllCourse();
    void viewFullCourse();
    void writeFullCourseFile();
    void viewStudentList();
    void viewStudentAllCourse();
    void sortCourse();
    void exit() throws IOException;

}
