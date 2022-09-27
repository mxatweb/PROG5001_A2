
/**
 * Assignment entity class.
 *
 * @author Martin Atwebembire
 * @version 0.1(17.09.2022)
 */
public class Assignment {
    // instance variables
    private String name;
    private String mark;

    /**
     * @param name
     * @param mark
     */
    public Assignment(String name, String mark) {
        // initialise instance variables
        this.name = name;
        this.mark = mark;
    }

    /**
     * @return assignment name
     */
    public String getAssignmentName() {
        return this.name;
    }

    /**
     * @return Assignment mark
     */
    public String getAssignmentMark() {
        return this.mark;
    }
}
