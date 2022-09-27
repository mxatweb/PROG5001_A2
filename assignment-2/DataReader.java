import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads data from the csv file.
 *
 * @author Martin Atwebembire
 * @version 0.1(17.09.2022)
 */
public class DataReader {
    private static String unitName;
    private static ArrayList<Student> studentRecords = new ArrayList<Student>();

    /*
     * 
     * F1: Read the unit name and students’ marks
     * from a given text file. The file contains the
     * unit name and the list of students with their
     * names, student ids and marks for three
     * assignments. The file also contains lines,
     * which are comments and your program
     * should check to ignore them when reading
     * the students’ marks.
     * 
     */

    public ArrayList<Student> getStudentRecords() {
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\inlig\\Downloads\\prog5001_students_grade_2022.csv"));

            unitName = sc.nextLine().split(":", 2)[1]; // read unit name

            sc.nextLine(); // Skip header text. (Last Name,First Name,Student ID,A1,A2,A3)

            // System.out.println("Olda,Aayush,23038615,21,,".split(",", -1).length);

            while (sc.hasNextLine()) {

                createStudentRecord(sc.nextLine());
            }
            // while(sc.hasNextLine()){
            // records.add(getRecordFromLine(scanner.nextLine()));
            // }
        } catch (Exception e) {
            System.out.println("Something went horribly wrong!");
        }

        return studentRecords;
    }

    /**
     * @param line
     */
    public void createStudentRecord(String line) {

        Unit unit;
        Student student;
        ArrayList<Assignment> assignments;
        String lastName;
        String firstName;
        String studentId;
        String A1;
        String A2;
        String A3;

        String[] studentRecord = line.split(",", -1);

        lastName = studentRecord[0];
        firstName = studentRecord[1];
        studentId = studentRecord[2];

        A1 = studentRecord[3];
        A2 = studentRecord[4];
        A3 = studentRecord[5];

        assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("A1", A1));
        assignments.add(new Assignment("A2", A2));
        assignments.add(new Assignment("A3", A3));

        unit = new Unit(unitName, assignments);

        student = new Student(lastName, firstName, studentId, unit);

        studentRecords.add(student);

    }

}
