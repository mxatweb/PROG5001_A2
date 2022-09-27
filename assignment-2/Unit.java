
/**
 * Unity entity class.
 *
 * @author Martin Atwebembire
 * @version 0.1(17.09.2022)
 */

import java.util.*;

public class Unit {
    // instance variables
    private String name;
    private ArrayList<Assignment> assignments;

    /**
     * @param name
     * @param assignments
     */
    public Unit(String name, ArrayList<Assignment> assignments) {

        this.name = name;
        this.assignments = assignments;
    }

    /**
     * @return Unit Name
     */
    public String getUnitName() {
        return this.name;
    }

    /**
     * @return List of assignments
     */
    public ArrayList<Assignment> getAssignments() {
        return this.assignments;
    }

}
