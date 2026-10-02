# Student Record Management System

## Overview
**Student Record Management System** is a clean, beginner-friendly, Java-based command-line (CLI) application used to manage student records through a menu-driven interface. Developed for **Java Developer Internship - Task 2**.

---

## Features
- ➕ **Add Student**: Add a new student record with a unique positive ID, name, and marks.
- 📋 **View Students**: Display all student records in a readable tabular format.
- ✏️ **Update Student**: Modify the name and marks of an existing student using their ID.
- 🗑️ **Delete Student**: Remove a student record using their unique Student ID.
- 🛡️ **Input Validation**: Prevents application crashes from invalid data types, duplicate IDs, blank names, and out-of-range marks (0–100).
- 🚪 **Exit**: Terminate the application safely with a goodbye message.

---

## Technologies Used
- **Java** (JDK 8+)
- **ArrayList** (`java.util.ArrayList`)
- **Object-Oriented Programming (OOP)** & **Encapsulation**
- **Scanner** (`java.util.Scanner`)
- **VS Code / IntelliJ IDEA / Terminal**

---

## Project Structure
```text
StudentRecordManagementSystem/
│
├── src/
│   ├── Student.java
│   └── StudentRecordManagementSystem.java
│
├── README.md
└── .gitignore
```

---

## Concepts Practiced
- **Classes & Objects**: Separate `Student` model class and `StudentRecordManagementSystem` driver class.
- **ArrayList**: `ArrayList<Student>` used to store multiple student objects dynamically in memory.
- **Encapsulation**: Student fields (`studentId`, `name`, `marks`) are declared `private` and accessed through getters and setters.
- **CRUD Operations**:
  - **Create** - Add Student
  - **Read** - View Students
  - **Update** - Update Student
  - **Delete** - Delete Student
- **Input Validation & Exception Safety**: Gracefully handles invalid numeric input, duplicate IDs, non-existent IDs, and out-of-bound marks.

---

## How to Run

### 1. Compile the Java files:
```bash
javac -d bin src/*.java
```

### 2. Run the application:
```bash
java -cp bin StudentRecordManagementSystem
```

---

## Example Usage

```text
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
```

---

## Interview Preparation Guide

### 1. What is Encapsulation?
Encapsulation binds data (fields) and methods operating on that data into a single unit (class), while restricting direct access using `private` modifiers and providing getters/setters.

### 2. ArrayList vs Arrays
- **Array**: Fixed size, supports primitives and objects.
- **ArrayList**: Dynamic size, stores reference objects, provides methods like `.add()`, `.remove()`, `.get()`.

### 3. How to Sort an ArrayList
Using `Collections.sort()` or `list.sort(Comparator.comparingDouble(Student::getMarks))`.

### 4. Constructor Overloading
Defining multiple constructors in the same class with different parameter lists.

### 5. Garbage Collection in Java
Automatic JVM memory management process that frees memory occupied by unreachable objects.

### 6. Why Getters and Setters are Used
To protect data integrity, enforce validation rules, and control read/write access to class fields.

### 7. Static Variables
Variables belonging to the class itself rather than instances, shared across all objects of that class.

### 8. The `final` Keyword
Prevents reassignment for variables, method overriding for methods, and class inheritance for classes.

### 9. Compile-time vs Runtime Errors
- **Compile-time**: Syntax or type errors caught by the compiler (`javac`).
- **Runtime**: Errors occurring during execution (e.g. `NullPointerException`, `InputMismatchException`).

### 10. Access Modifiers
- `private`: Class-only access.
- Default: Package-only access.
- `protected`: Package and subclass access.
- `public`: Universal access.

---

## Author
**Sumanth Kateboina**
