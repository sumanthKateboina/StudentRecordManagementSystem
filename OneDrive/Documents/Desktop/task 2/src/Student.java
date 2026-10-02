/**
 * Student.java
 * 
 * Represents a Student entity in the Student Record Management System.
 * Demonstrates OOP encapsulation using private fields, getters, and setters.
 */
public class Student {
    
    // Private fields for encapsulation
    private int studentId;
    private String name;
    private double marks;

    /**
     * Parameterized Constructor to initialize a Student object.
     * 
     * @param studentId Unique ID of the student
     * @param name      Full name of the student
     * @param marks     Academic marks (0 to 100)
     */
    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    // --- Getters and Setters (Encapsulation) ---

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    /**
     * Returns a formatted String representation of the Student.
     */
    @Override
    public String toString() {
        return String.format("ID: %-8d | Name: %-20s | Marks: %-6.2f", studentId, name, marks);
    }
}
