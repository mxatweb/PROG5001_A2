
/**
 * Manages student marks
 *
 * @author Martin Atwebembire
 * @version 0.1(17.09.2022)
 */
import java.util.*;

public class StudentRecord {

    // private static String unitName;
    private static ArrayList<Student> data = new ArrayList<Student>();
    private static DataReader dataReader = new DataReader();

    public static void main(String[] args) {

        /*
         * F5: Create a simple menu system to allow
         * users to select and execute each function
         * (algorithm 2).
         * 
         */
        System.out.println("MAIN MENU");
        System.out.println("1) Read Text File");
        System.out.println("2) Print Total Marks");
        System.out.println("3) Print Marks Less Than Threshold");
        System.out.println("4) Print Top 10 Lowest & Highest Marks");
        System.out.println("5) Exit.");
        System.out.println();
        System.out.print("> Select a menu option to continue: ");
        getMenuOption();

    }

    /*
     *
     * F2: Calculate the total mark for each student
     * from the assessment marks and print out the
     * list of students with their name, student id,
     * assessment marks and the total mark.
     */

    private static void getMenuOption() {

        String menu_option;

        Scanner input = new Scanner(System.in);

        menu_option = input.nextLine().trim();

        // validate input
        try {
            int choice = Integer.parseInt(menu_option);
            if (choice > 5 || choice < 0) {
                // input.close();
                System.out.println("Invalid Menu Option. Try Again!");
                System.out.print("> Select a menu option to continue: ");
                getMenuOption();

            }

        } catch (Exception e) {
            System.out.println("Invalid Menu Option. Try Again!");
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();

        }

        // finally {
        // System.out.print("> Select a menu option to continue: ");
        // getMenuOption();
        // input.close();

        // }

        if (menu_option.equals("1")) {
            // option 1
            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            System.out.println("Text file successfully read!");
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("2")) {
            // menu option 2

            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            printStudentRecords();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("3")) {
            // menu option 3
            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            printMarksLessThanThreshold();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("4")) {
            // menu option 4
            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            printTopTenStudents();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("5")) {
            System.out.println("Program exited...goodbye!");
            System.exit(0);
        }

    }

    public static void printStudentRecords() {

        double total = 0;
        int i = 1;
        String unitName;
        String studentName;
        String studentId;

        String assignment_1_name;
        String assignment_2_name;
        String assignment_3_name;

        double assignment_1_mark;
        double assignment_2_mark;
        double assignment_3_mark;

        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");
        System.out.println(
                "|                 List of students with their name, id, assessment marks, and total mark                           |");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");

        for (Student student : data) {
            unitName = student.getUnit().getUnitName(); // not asked to print out unit name
            studentName = student.getStudentName();
            studentId = student.getStudentId();

            assignment_1_name = student.getUnit().getAssignments().get(0).getAssignmentName();
            assignment_1_mark = student.getUnit().getAssignments().get(0).getAssignmentMark().isEmpty() ? 0
                    : Double.parseDouble(student.getUnit().getAssignments().get(0).getAssignmentMark());

            assignment_2_name = student.getUnit().getAssignments().get(1).getAssignmentName();
            assignment_2_mark = student.getUnit().getAssignments().get(1).getAssignmentMark().isEmpty() ? 0
                    : Double.parseDouble(student.getUnit().getAssignments().get(1).getAssignmentMark());

            assignment_3_name = student.getUnit().getAssignments().get(2).getAssignmentName();
            assignment_3_mark = student.getUnit().getAssignments().get(2).getAssignmentMark().isEmpty() ? 0
                    : Double.parseDouble(student.getUnit().getAssignments().get(2).getAssignmentMark());

            ArrayList<Assignment> assignments = student.getUnit().getAssignments();

            for (Assignment assignment : assignments) {
                if (!assignment.getAssignmentMark().isEmpty()) {
                    total += Double.parseDouble(assignment.getAssignmentMark());
                }
            }
            // print unit name
            // System.out.println("Unit Name: " + unitName);

            /*
             * Print name, id, assessment marks, and total mark
             */
            System.out.println(
                    "#" + i + " Student Name: " + studentName + " , " + "ID: " + studentId + " , " + assignment_1_name
                            + ": " + assignment_1_mark + " , " + assignment_2_name
                            + ": " + assignment_2_mark + " , " + assignment_3_name
                            + ": " + assignment_3_mark + " , " + "Total Mark: " + total);
            System.out.println();
            i++;
            total = 0;

        }
        i = 1;

    }

    /*
     * F3: Print the list of students with the total
     * marks less than a certain threshold. The
     * threshold will be entered from keyboard.
     */

    public static void printMarksLessThanThreshold() {

        double threshold = 0.0;
        double total = 0.0;
        int i = 1;

        // get threshold
        // perform error handling

        Scanner input = new Scanner(System.in);
        System.out.print("> Enter Threshold: ");

        // validate input
        try {
            threshold = input.nextDouble();
            System.out.println(
                    "+------------------------------------------------------------------------------------------------------------------+");
            System.out.println(
                    "|                 List of students with their total marks less than a certain threshold                            |");
            System.out.println(
                    "+------------------------------------------------------------------------------------------------------------------+");

        } catch (Exception e) {
            System.out.println("Invalid Input. Please try again!");

        }

        // loop through data, and use threshold to filter data

        for (Student student : data) {

            ArrayList<Assignment> assignments = student.getUnit().getAssignments();

            for (Assignment assignment : assignments) {
                if (!assignment.getAssignmentMark().isEmpty()) {
                    total += Double.parseDouble(assignment.getAssignmentMark());
                }
            }
            if (total < threshold) {
                System.out.println(
                        "#" + i + " Student Name: " + student.getStudentName() + " , " + "Total Mark: " + total);
                System.out.println();
                i++;

            }

            total = 0;

        }
        i = 1;

    }

    /*
     * F4: Print the top 10 students with the highest
     * total marks and top 10 students with the
     * lowest total marks (algorithm 1).
     */
    public static void printTopTenStudents() {
        double total = 0.0;
        String studentName;
        Map<String, Double> map = new HashMap<String, Double>();
        ArrayList<Double> tenHighestMarks = new ArrayList<Double>();
        ArrayList<Double> tenLowestMarks = new ArrayList<Double>();

        for (Student student : data) {

            studentName = student.getStudentName();

            ArrayList<Assignment> assignments = student.getUnit().getAssignments();

            for (Assignment assignment : assignments) {
                if (!assignment.getAssignmentMark().isEmpty()) {
                    total += Double.parseDouble(assignment.getAssignmentMark());
                }
            }

            map.put(studentName, total);
            total = 0;

        }

        List<Double> totalMarks = new ArrayList<>(map.values());
        Collections.sort(totalMarks);

        Set<Double> set = new LinkedHashSet<>(); // remove duplicates

        set.addAll(totalMarks);
        totalMarks.clear();
        totalMarks.addAll(set);

        // get Lowest 10
        for (int i = 0; i < 10; i++) {
            tenLowestMarks.add(totalMarks.get(i));
        }
        // get Highest 10
        for (int i = totalMarks.size() - 1; i >= totalMarks.size() - 10; i--) {
            tenHighestMarks.add(totalMarks.get(i));
        }

        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");
        System.out.println(
                "|                                    List of students with the top ten highest marks                                |");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");

        for (Double mark : tenHighestMarks) {

            if (map.containsValue(mark)) {
                for (Map.Entry<String, Double> record : map.entrySet()) {
                    if (record.getValue().equals(mark)) {
                        System.out.println(
                                "Student Name: " + record.getKey() + " , " + "Total Mark: " + record.getValue());

                    }

                }

            }

        }

        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");
        System.out.println(
                "|                                    List of students with the top ten lowest marks                                 |");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------+");

        for (Double mark : tenLowestMarks) {

            if (map.containsValue(mark)) {
                for (Map.Entry<String, Double> record : map.entrySet()) {
                    if (record.getValue().equals(mark)) {
                        System.out.println(
                                "Student Name: " + record.getKey() + " , " + "Total Mark: " + record.getValue());

                    }

                }

            }

        }

    }

}
