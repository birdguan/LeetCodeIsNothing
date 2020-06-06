package DesignPattern.J2EEPatterns.MVCPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 12:03
 */
public class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
