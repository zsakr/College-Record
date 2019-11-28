import java.util.Scanner;

/**
 * Application program for the Directory class.
 * @author Ziad Sakr
 * @author Zorawar Moolenaar
 * @author Ewa Syta
 * @version 1.0 29/4/2018
 */

public class DirectoryDemo {
    private static Directory trinity;
    private static String first, last, email, phoneNumber, department, rank, position;
    private static int graduationYear;

    /**
     * Runs the Directory application program.
     *
     * @param args list of command line arguments
     */
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in); // needed for user input
        int userChoice; // Stores the user's choice of task to execute
        trinity = new Directory("Trinity College"); // Creates a new instance of the Directory class

        // This method adds three entries to the directory for testing
        // addTestEntries();

        do {
            clear();
            System.out.println("\t|--------------------------------------------------------------|");
            System.out.println("\t|             Student, Faculty and Staff Directory             |");
            System.out.println("\t|                       Trinity College                        |");
            System.out.println("\t|---------------------===================----------------------|");
            System.out.println("\t|                    Supported Operations                      |");
            System.out.println("\t|--------------------------------------------------------------|");
            System.out.println("\t|     1. Add a student entry   2. Add a faculty entry          |");
            System.out.println("\t|     3. Add a staff entry     4. Remove an entry              |");
            System.out.println("\t|     5. Search for an entry   6. Sort all entries             |");
            System.out.println("\t|     7. Display all entries   8. Display number of entries    |");
            System.out.println("\t|                        9. Quit                               |");
            System.out.println("\t|--------------------------------------------------------------|");
            System.out.print("\t   Enter a number to perform a task: ");
            switch (userChoice = keyboard.nextInt()) {
                case 1:
                    addStudentEntry();
                    break;
                case 2:
                    addFacultyEntry();
                    break;
                case 3:
                    addStaffEntry();
                    break;
                case 4:
                    removeEntry();
                    break;
                case 5:
                    searchEntries();
                    break;
                case 6:
                    sortEntries();
                    break;
                case 7:
                    displayEntries();
                    break;
                case 8:
                    displayTotalEntries();
                    break;
                case 9:
                    return;
                default:
                    System.out.println(">>> Invalid Option. Try Again <<<");
            }
            waitForInteraction();
        } while (userChoice != 9);
    }


    /**
     * Obtains information common to all types of entries.
     * This is a helper method for addStudentEntry(),
     * addFacultyEntry() and addStaffEntry().
     */
    private static void getEntryInfo() {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("First name: ");
        first = keyboard.nextLine();

        System.out.print("Last name: ");
        last = keyboard.nextLine();

        System.out.print("Email address: ");
        email = keyboard.nextLine();

        System.out.print("Phone number: ");
        phoneNumber = keyboard.nextLine();

        System.out.print("Department: ");
        department = keyboard.nextLine();
    }

    /**
     * Creates and adds a new Student entry to the directory.
     * Displays the outcome of this operation.
     */
    private static void addStudentEntry() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Adding a new student entry...");
        getEntryInfo();
        System.out.print("Graduation year: ");
        graduationYear = keyboard.nextInt();
        Entry newEntry = new StudentEntry(first, last, email, phoneNumber, department, graduationYear);

        if (trinity.add(newEntry))
            System.out.println("Entry successfully added.");
        else
            System.out.println("Entry could not be added.");
    }

    /**
     * Creates and adds a new Faculty entry to the directory.
     * Displays the outcome of this operation.
     */
    private static void addFacultyEntry() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Adding a new faculty entry...");
        getEntryInfo();
        System.out.print("Rank: ");
        rank = keyboard.nextLine();
        Entry newEntry = new FacultyEntry(first, last, email, phoneNumber, department, rank);

        if (trinity.add(newEntry))
            System.out.println("Entry successfully added.");
        else
            System.out.println("Entry could not be added.");
    }

    /**
     * Creates and adds a new Staff entry to the directory.
     * Displays the outcome of this operation.
     */
    private static void addStaffEntry() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Adding a new staff entry...");

        getEntryInfo();

        System.out.print("Position: ");
        position = keyboard.nextLine();
        Entry newEntry = new StaffEntry(first, last, email, phoneNumber, department, position);

        if (trinity.add(newEntry))
            System.out.println("Entry successfully added.");
        else
            System.out.println("Entry could not be added.");
    }

    /**
     * Removes an existing entry based on the provided last name.
     * Displays the outcome of this operation. Specifically,
     * if the provided last name did not correspond to any
     * entry in the directory.
     */
    private static void removeEntry() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a last name to remove an entry: ");
        String last = keyboard.nextLine();
        if (trinity.remove(last))
            System.out.println("Entry successfully removed.");
        else
            System.out.println("Entry not found and could not be removed.");
    }

    /**
     * Searches for an entry based on the provided last name.
     * Displays the outcome of this operation.
     * If found, displays the entry.
     * If not, displays a proper message.
     */
    private static void searchEntries() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a last name to search: ");
        String last = keyboard.nextLine();
        Entry foundEntry = trinity.search(last);

        if (foundEntry != null) {
            System.out.println("Entry successfully located.");
            System.out.println(foundEntry);
        } else
            System.out.println("Entry could not be located.");
    }

    /**
     * Displays all entries in the directory.
     */
    private static void displayEntries() {
        System.out.println(trinity);
    }

    /**
     * Displays the total number of entries in the directory.
     */
    private static void displayTotalEntries(){
        System.out.println("There are " + trinity.getTotalEntries() + " entries in the directory.");
    }

    /**
     * Sorts all entries in the directory.
     */
    private static void sortEntries() {
        trinity.sort();
        System.out.println("Entries have been sorted.");
    }


    /**
     * Adds three test entries to the directory.
     * FOR TESTING PURPOSES ONLY.
     */
    private static void addTestEntries() {
        Entry testStudent = new StudentEntry("Sam", "Student", "sam@trincoll.edu", "860-111-1111", "MATH", 2020);
        Entry testFaculty = new FacultyEntry("Frank", "Faculty",  "frank@trincoll.edu", "203-222-2222", "CHEM",  "Assistant Professor");
        Entry testStaff = new StaffEntry("Samantha", "Staff",  "samantha@trincoll.edu", "781-333-3333", "REL", "Clerical");

        trinity.add(testStudent);
        trinity.add(testFaculty);
        trinity.add(testStaff);
    }

    /**
     * Clears the terminal screen.
     * <p>
     * Code credit: <a href="https://goo.gl/y4q4Hg">here</a>. May not work on all consoles.
     */
    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Prevents the screen from clearing until the user confirms.
     */
    private static void waitForInteraction() {
        Scanner s = new Scanner(System.in);
        System.out.println("\t>>> Hit <Enter> to complete operation and clear screen. <<<");
        s.nextLine();
    }
}
