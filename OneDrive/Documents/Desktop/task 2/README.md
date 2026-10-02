# Student Record Management System

A clean, beginner-friendly, Command-Line Interface (CLI) based CRUD application built in Core Java for managing student records. Developed as part of **Java Developer Internship - Task 2**.

---

## Table of Contents
- [Description](#description)
- [Objective](#objective)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [How to Run the Project](#how-to-run-the-project)
  - [Prerequisites](#prerequisites)
  - [Command Line (Terminal / Command Prompt)](#command-line-terminal--command-prompt)
  - [VS Code](#vs-code)
  - [IntelliJ IDEA](#intellij-idea)
- [Example CLI Usage](#example-cli-usage)
- [Concepts Demonstrated](#concepts-demonstrated)
- [Future Improvements](#future-improvements)
- [GitHub Submission Instructions](#github-submission-instructions)
- [Interview Preparation Guide](#interview-preparation-guide)

---

## Description
The **Student Record Management System** is an in-memory Java CLI application that allows users to perform basic CRUD (Create, Read, Update, Delete) operations on student records. It leverages object-oriented programming principles, specifically encapsulation, class/object design, and data structures (`ArrayList`), while providing complete input validation to safeguard against invalid data and runtime crashes.

---

## Objective
To build a fundamental Java project that demonstrates mastery of core programming concepts, object-oriented design, dynamic data storage using `ArrayList`, and robust console user input handling—suitable for entry-level Java developers and software engineering interns.

---

## Features
- **Add Student**: Add a new student with a unique positive ID, name, and marks (0.0 to 100.0).
- **View All Students**: Display all stored student records in a formatted tabular view. Handles empty list scenarios gracefully.
- **Update Student**: Modify a student's name and marks using their unique ID (ID remains unchanged for identity preservation).
- **Delete Student**: Remove a student record using their unique Student ID.
- **Input Validation**: Prevents application crashes from invalid data types (e.g. typing text when a number is required), out-of-bounds marks, negative IDs, and blank names.
- **Unique Student ID**: Rejects creation of duplicate student IDs to guarantee unique identification.

---

## Technologies Used
- **Language**: Java (JDK 8 or higher)
- **Data Structure**: `java.util.ArrayList`
- **I/O Library**: `java.util.Scanner`
- **Build Tools**: Standard Java Compiler (`javac`) and Runtime (`java`)

---

## Project Structure
```text
StudentRecordManagementSystem/
├── src/
│   ├── Student.java
│   └── StudentRecordManagementSystem.java
├── README.md
└── .gitignore
```

---

## How to Run the Project

### Prerequisites
- Install **JDK 8** or higher (Java Development Kit).
- Verify installation by running in your terminal:
  ```bash
  java -version
  javac -version
  ```

### Command Line (Terminal / Command Prompt)
1. Open your terminal and navigate to the project directory:
   ```bash
   cd "path/to/task 2"
   ```
2. Compile the Java files into a `bin` output folder:
   ```bash
   javac -d bin src/*.java
   ```
3. Run the compiled application:
   ```bash
   java -cp bin StudentRecordManagementSystem
   ```

### VS Code
1. Open the project folder in VS Code (`File` > `Open Folder...`).
2. Install the **Extension Pack for Java** if not already installed.
3. Open `src/StudentRecordManagementSystem.java`.
4. Click the **Run** button above `public static void main(String[] args)` or press `Ctrl + F5`.

### IntelliJ IDEA
1. Open IntelliJ IDEA and select **Open** to choose the project folder.
2. Ensure the `src` directory is marked as the **Sources Root** (Right-click `src` > `Mark Directory as` > `Sources Root`).
3. Open `src/StudentRecordManagementSystem.java`.
4. Click the green **Run** arrow next to the `main` method or press `Shift + F10`.

---

## Example CLI Usage

```text
==================================================
   Welcome to Student Record Management System    
==================================================

===== Student Record Management System =====
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 1

--- Add New Student ---
Enter Student ID (Positive Integer): 101
Enter Student Name: Alice Smith
Enter Marks (0.0 to 100.0): 92.5
[Success] Student record added successfully!

===== Student Record Management System =====
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 2

--- View All Students ---
----------------------------------------------------------
Student ID | Student Name              | Marks     
----------------------------------------------------------
101        | Alice Smith               | 92.50     
----------------------------------------------------------
Total Students: 1

===== Student Record Management System =====
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 5

Thank you for using Student Record Management System. Goodbye!
```

---

## Concepts Demonstrated
1. **Encapsulation**: Private fields (`studentId`, `name`, `marks`) with getter and setter methods.
2. **Dynamic Collection (`ArrayList`)**: Dynamic sizing for storing object references in memory.
3. **Control Flow**: `while` loops, `switch-case` blocks, and `if-else` branching.
4. **Input Handling & Exception Safety**: Reading lines with `Scanner.nextLine()` and parsing with `Integer.parseInt()` / `Double.parseDouble()` inside `try-catch` blocks to prevent scanner buffer misalignment and crashes.
5. **String Formatting**: `System.out.printf()` for structured console outputs.

---

## Future Improvements
- **Data Persistence**: Save and load student records to/from a CSV file or JSON file.
- **Search & Sort Options**: Search by name or sort students by marks (ascending/descending).
- **Grade Calculation**: Automatically assign letter grades (A, B, C, D, F) based on marks.
- **Database Integration**: Connect to JDBC / SQLite / MySQL for persistent database storage.

---

## GitHub Submission Instructions
1. Initialize a local git repository:
   ```bash
   git init
   ```
2. Add files and make your initial commit:
   ```bash
   git add .
   git commit -m "Add Student Record Management System CLI application"
   ```
3. Create a repository on GitHub named `StudentRecordManagementSystem`.
4. Link local repository and push:
   ```bash
   git branch -M main
   git remote add origin https://github.com/<your-username>/StudentRecordManagementSystem.git
   git push -u origin main
   ```

---

## Interview Preparation Guide

This section contains quick notes and explanations for common Java technical interview questions related to this project.

### 1. What is encapsulation?
**Definition**: Encapsulation is one of the fundamental OOP principles that binds together data (variables) and methods operating on that data into a single unit (class), while restricting direct access to internal implementation details using `private` access modifiers.

**Example**:
```java
public class Student {
    private double marks; // Private field protects data

    public double getMarks() { return marks; }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks; // Validation rules enforced
        }
    }
}
```

---

### 2. ArrayList vs Arrays

| Feature | Java Array (`int[]`) | `ArrayList<T>` |
| :--- | :--- | :--- |
| **Size** | Fixed size at initialization | Dynamic resizing automatically |
| **Data Types** | Holds primitives and objects | Holds only reference objects (uses wrappers for primitives) |
| **Performance** | Slightly faster, less memory overhead | Slightly higher overhead due to dynamic array resizing |
| **Methods** | Uses `.length` property | Uses `.size()`, `.add()`, `.remove()`, `.get()` methods |

---

### 3. How to sort an ArrayList
In Java, an `ArrayList` can be sorted using `Collections.sort()` or `ArrayList.sort()`.

**Example using Comparator**:
```java
import java.util.ArrayList;
import java.util.Comparator;

ArrayList<Student> students = new ArrayList<>();
// Sort by Marks descending
students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
```

---

### 4. What is constructor overloading?
Constructor overloading occurs when a class has multiple constructors with the same name but different parameter lists (number, type, or order of parameters).

**Example**:
```java
public class Student {
    private int id;
    private String name;

    // Default Constructor
    public Student() {}

    // Parameterized Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

---

### 5. Garbage Collection in Java
**Definition**: Garbage Collection (GC) is Java's automatic memory management process in the JVM that frees up memory occupied by objects that are no longer referenced or reachable in the program.

**Key point**: Developers do not need to manually deallocate memory (unlike C/C++ `free()` or `delete`). You can request GC via `System.gc()`, though the JVM decides when to execute it.

---

### 6. Why getters and setters are used?
- **Data Protection**: Prevents external code from setting variables to invalid states (e.g. setting negative marks).
- **Flexibility / Read-Only**: Allows creating read-only or write-only properties by providing only a getter or setter.
- **Maintainability**: Keeps internal representation hidden; if internal representation changes, getters and setters remain compatible.

---

### 7. What are `static` variables?
A `static` variable belongs to the **class** itself rather than to any specific instance (object) of the class. All instances share the exact same copy of a static variable.

**Example**:
```java
public class Student {
    public static int totalStudentCount = 0; // Shared across all Student instances
}
```

---

### 8. What is the `final` keyword?
The `final` keyword is used to declare constants or prevent overriding/inheritance:
- **`final` variable**: Cannot be reassigned once initialized (constant).
- **`final` method**: Cannot be overridden by subclasses.
- **`final` class**: Cannot be subclassed (extended).

---

### 9. Compile-time vs Runtime Errors

- **Compile-time Error**: Detected by `javac` during code compilation before execution (e.g. syntax errors, missing semicolons, type mismatches).
- **Runtime Error**: Occurs while the program is running (e.g. `NullPointerException`, `ArithmeticException` like division by zero, `InputMismatchException`).

---

### 10. What are access modifiers?
Access modifiers define the visibility and accessibility of classes, constructors, methods, and fields:

1. **`private`**: Accessible only within the declaring class.
2. **Default (package-private)**: Accessible only within the same package.
3. **`protected`**: Accessible within the same package and by subclasses in other packages.
4. **`public`**: Accessible from any other class anywhere.
