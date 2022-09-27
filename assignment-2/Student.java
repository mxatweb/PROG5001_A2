
/**
 * This class defines the studet's record.
 *
 * @author Martin Atwebembire
 * @version 0.1(17.09.2022)
 */

// import java.util.*;

public class Student {
    // instance variables
    private String lastName;
    private String firstName;
    private String studentId;
    private Unit unit;

    /**
     * @param lastName
     * @param firstName
     * @param studentId
     * @param unit
     */
    public Student(String lastName, String firstName, String studentId, Unit unit) {
        // initialise instance variables
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentId = studentId;
        this.unit = unit;
    }

    /**
     * @return Student's Full Name
     */
    public String getStudentName() {
        return this.lastName + " " + this.firstName;
    }

    /**
     * @return Student ID
     */
    public String getStudentId() {
        return this.studentId;
    }

    /**
     * @return Unit Object - This object stores the unit name, and a list of
     *         assignments for that unit
     */
    public Unit getUnit() {
        return this.unit;
    }

}
