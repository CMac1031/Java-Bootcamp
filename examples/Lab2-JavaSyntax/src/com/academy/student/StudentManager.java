package com.academy.student;

import java.util.Scanner;

public class StudentManager {

    private static final int MAX_STUDENTS = 20;

    private final Student[] students = new Student[MAX_STUDENTS];
    private int studentCount = 0;
    private final Scanner scanner;

    public StudentManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("====================================");
        System.out.println("Student Management System");
        System.out.println("====================================");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Average Marks");
        System.out.println("5. Exit");
        System.out.print("Enter Choice : ");
    }

    // Methods addStudent, displayStudents, searchStudent, calculateAverage
    public void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Class FULL!");
            return;
        }

        int id = readPositiveInt("Student ID: ");
        if (findStudentIndex(id) != -1) {
            System.out.print("\n");
            System.out.println("Student ID already exists.");
            return;
        }
        String name = readNonEmptyLine("Name: ");
        String course = readNonEmptyLine("Course: ");
        double marks = readValidMarks("Marks: ");

        students[studentCount] = new Student(id, name, course, marks);
        studentCount++;
        System.out.print("\n");
        System.out.println("Student Added Successfully.");
    }
    public void displayStudents(){
        System.out.print("\n");
        if(studentCount == 0){
            System.out.println("No students to display.");
            return;
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-8s%-21s%-16s%s%n",
                "ID", "Name", "Course", "Marks");
        System.out.println("----------------------------------------------------------");
        for(int i =0; i < studentCount ; i ++){
            System.out.printf("%-8d %-20s %-15s %-8.2f%n",
                    students[i].getStudentId(),
                    students[i].getName(),
                    students[i].getCourse(),
                    students[i].getMarks());
            System.out.println("----------------------------------------------------------");
        }

    }
    public void searchStudent(){
        if(studentCount == 0){
            System.out.print("\n");
            System.out.println("No students to search.");
            return;
        }
        int id = readPositiveInt("Student ID: ");
        int index = findStudentIndex(id);
        if(index == -1){
            System.out.print("\n");
            System.out.println("Student Not Found.");
        }
        else{
            System.out.print("\n");
            students[index].display();
        }

    }
    public void calculateAverage(){
        double sum=0;
        if(studentCount == 0){
            System.out.print("\n");
            System.out.println("No average available because there are no students.");
            return;
        }
        for(int i = 0 ; i < studentCount ; i ++){
                sum += students[i].getMarks();
        }

        double average = sum/studentCount;
        System.out.print("\n");
        System.out.printf("Average Marks: %-8.2f\n",average);

    }
    //HELPER METHODS--------------------------------------------------------------------------
    private int readPositiveInt(String prompt) {
        int id = -1;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                id = Integer.parseInt(input);

                if (id <= 0) {
                    System.out.println("ID must be a positive number.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("ID must be a valid whole number.");
                id = -1;
            }
        } while (id <= 0 );
        return id;
    }
    private String readNonEmptyLine(String prompt){
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (input.length() !=0) {
                return input;
            }
            System.out.println("Input cannot be empty.");
        }
    }
    private double readValidMarks(String prompt) {
        double marks = -1;
        while (marks < 0 || marks > 100) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                 marks = Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) {
                   return marks;
                }
                System.out.println("Marks must be between 0 and 100.");
            } catch (NumberFormatException exception) {
                System.out.println("Marks must be a valid number.");
                marks = -1;
            }
        }
        return marks;
    }
    private int findStudentIndex(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == id) {
                return i;
            }
        }
        return -1;
    }

}