import java.io.IOException;

public interface CollegeStudent {
//student class will implement this interface
    void viewAllCourse();
    void viewNotFullCourse();
    void registerCourse();
    void withdrawCourse();
    void viewMyCourse();
    void exit() throws IOException;
}
