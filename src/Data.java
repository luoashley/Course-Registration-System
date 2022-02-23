import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class Data implements Serializable{
    public static ArrayList<Course> courseList = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();

    //getter and setter
    public static ArrayList<Course> getCourseList() {return courseList;}
    public static void setCourseList(ArrayList<Course> courseList) {courseList = courseList;}
    public static ArrayList<Student> getStudentList() {return studentList;}
    public static void setStudentList(ArrayList<Student> studentList) {studentList = studentList;}

    //Read the initial file
    public static String[][] readCSV(String fn) throws FileNotFoundException {
        Scanner input = new Scanner(fn);
        String[][] ss = new String[100][8];
        try{
            BufferedReader br = new BufferedReader(new FileReader(fn));
            String s;
            int i = 0;
            while ((s = br.readLine()) != null) {
                ss[i++] = s.split(",");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        input.close();
        return ss;
    }

    public static void readCourseCSV(String fn) throws IOException {
        String[][] ss;
        ss = readCSV(fn);
        int i = 1;
        while (ss[i][0] != null){
            courseList.add(new Course(ss[i][0], ss[i][1], Integer.parseInt(ss[i][2]), Integer.parseInt(ss[i][3]),
                    ss[i][5], ss[i][6], ss[i][7]));
            i++;
        }
    }

    //Serialize list
    public static void storeList(){
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Data.dat"));
            output.writeObject(courseList);
            output.writeObject(studentList);
            output.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Deserialize list
    public static void retrieveList(File file) throws IOException{
        File in = file;
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(in));
        try{
            courseList = (ArrayList<Course>)input.readObject();
            studentList =(ArrayList<Student>)input.readObject();
            input.close();
        }catch (EOFException e){
            input.close();
        }catch (ClassNotFoundException | IOException e){
            input.close();
            e.printStackTrace();
        }
    }


    //Write full course to a file
    public static void writeFullCourseFile(){
        String fileName = "fullCourse.csv";
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for(Course c : courseList){
                if(c.getCurrentStudents() == c.getMaxStudents()) {
                    bufferedWriter.write(c.getCourseName() + "," + c.getCourseID() + "," + c.getMaxStudents() +
                            "," + c.getCurrentStudents() + "," + c.getStudentList() + "," + c.getCourseInstructor() +
                            "," + c.getCourseSection() + "," + c.getCourseLocation());
                }
            }
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException exk) {
            System.out.println( "Error writing file '" + fileName + "'");
            exk.printStackTrace();
        }
    }

    public static ArrayList<Course> sortCourse(){
        for(int i = 0; i < courseList.size() - 1; i++){
            int m = i;
            for(int j = i + 1; j < courseList.size(); j++){
                int a = courseList.get(m).getCurrentStudents();
                int b = courseList.get(j).getCurrentStudents();
                if(a > b)
                    m = j;
            }
            //swapping elements at position i and m
            Course temp = courseList.get(i);
            courseList.set(i, courseList.get(m));
            courseList.set(m, temp);
        }
        return courseList;
    }

    public static void addCourse(Course a){courseList.add(a);}
    public static void removeCourse(Course a){courseList.remove(a);}
}
