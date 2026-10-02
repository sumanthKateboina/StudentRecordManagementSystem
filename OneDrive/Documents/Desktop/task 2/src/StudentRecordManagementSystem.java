import java.util.ArrayList;
import java.util.Scanner;

/**
 * StudentRecordManagementSystem.java
 * 
 * Main driver class for the CLI-based Student Record Management System.
 * Demonstrates CRUD operations on an ArrayList of Student objects with
 * robust user input validation and error handling.
 */
public class StudentRecordManagementSystem {

    // List to store Student objects in memory
    private static final ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("==================================================");
        System.out.println("   Welcome to Student Record Management System    ");
        System.out.println("==================================================");

        while (running) {
            displayMenu();
            int choice = readInt(scanner, "Enter your choice: ");
            System.out.println();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using Student Record Management System. Goodbye!");
                    break;
                default:
                    System.out.println("[Error] Invalid choice! Please enter a number between 1 and 5.");
            }
            System.out.println();
        }

        scanner.close();
    }

    /**
     * Displays the main interactive CLI menu.
     */
    private static void displayMenu() {
        System.out.println("===== Student Record Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    /**
     * Operation 1: Add a new student record to the system.
     * Validates student ID uniqueness, non-empty name, and marks range [0, 100].
     */
    private static void addStudent(Scanner scanner) {
        System.out.println("--- Add New Student ---");

        int studentId;
        while (true) {
            studentId = readPositiveInt(scanner, "Enter Student ID (Positive Integer): ");
            if (findStudentById(studentId) != null) {
                System.out.println("[Error] Student ID " + studentId + " already exists. Duplicate IDs are not allowed.");
            } else {
                break;
            }
        }

        String name = readNonBlankString(scanner, "Enter Student Name: ");
        double marks = readDoubleInRange(scanner, "Enter Marks (0.0 to 100.0): ", 0.0, 100.0);

        Student student = new Student(studentId, name, marks);
        studentList.add(student);

        System.out.println("[Success] Student record added successfully!");
    }

    /**
     * Operation 2: Displays all student records in a formatted table layout.
     * Displays an appropriate message if the list is empty.
     */
    private static void viewStudents() {
        System.out.println("--- View All Students ---");
        if (studentList.isEmpty()) {
            System.out.println("No student records found. The student list is currently empty.");
            return;
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("%-10s | %-25s | %-10s\n", "Student ID", "Student Name", "Marks");
        System.out.println("----------------------------------------------------------");
        for (Student s : studentList) {
            System.out.printf("%-10d | %-25s | %-10.2f\n", s.getStudentId(), s.getName(), s.getMarks());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Total Students: " + studentList.size());
    }

    /**
     * Operation 3: Updates the name and marks of an existing student record.
     * Student ID cannot be modified to preserve identity integrity.
     */
    private static void updateStudent(Scanner scanner) {
        System.out.println("--- Update Student Record ---");
        if (studentList.isEmpty()) {
            System.out.println("No student records found to update.");
            return;
        }

        int studentId = readPositiveInt(scanner, "Enter Student ID to update: ");
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("[Error] Student with ID " + studentId + " does not exist.");
            return;
        }

        System.out.println("Current Record: " + student);
        String newName = readNonBlankString(scanner, "Enter New Student Name: ");
        double newMarks = readDoubleInRange(scanner, "Enter New Marks (0.0 to 100.0): ", 0.0, 100.0);

        student.setName(newName);
        student.setMarks(newMarks);

        System.out.println("[Success] Student record updated successfully!");
    }

    /**
     * Operation 4: Deletes a student record by Student ID.
     */
    private static void deleteStudent(Scanner scanner) {
        System.out.println("--- Delete Student Record ---");
        if (studentList.isEmpty()) {
            System.out.println("No student records found to delete.");
            return;
        }

        int studentId = readPositiveInt(scanner, "Enter Student ID to delete: ");
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("[Error] Student with ID " + studentId + " does not exist.");
            return;
        }

        studentList.remove(student);
        System.out.println("[Success] Student record with ID " + studentId + " deleted successfully!");
    }

    /**
     * Helper Method: Finds a student by ID in the studentList.
     * 
     * @param id Student ID to search for
     * @return Student object if found, null otherwise
     */
    private static Student findStudentById(int id) {
        for (Student s : studentList) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }

    // =========================================================================
    // Safe Input Helper Methods (Prevents InputMismatchException and Crashing)
    // =========================================================================

    /**
     * Reads a line of input and parses it as an integer. Reprompts until valid.
     */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[Error] Invalid numeric input! Please enter a valid integer.");
            }
        }
    }

    /**
     * Reads a positive integer (> 0). Reprompts until valid.
     */
    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            int value = readInt(scanner, prompt);
            if (value <= 0) {
                System.out.println("[Error] Student ID must be a positive integer greater than 0.");
            } else {
                return value;
            }
        }
    }

    /**
     * Reads a double value within a specified range [min, max]. Reprompts until valid.
     */
    private static double readDoubleInRange(Scanner scanner, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < min || value > max) {
                    System.out.printf("[Error] Value must be between %.1f and %.1f.\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error] Invalid numeric input! Please enter a valid number.");
            }
        }
    }

    /**
     * Reads a non-blank string input. Reprompts until valid.
     */
    private static String readNonBlankString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("[Error] Name cannot be blank! Please enter a valid name.");
            } else {
                return input;
            }
        }
    }
}
