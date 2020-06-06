package DesignPattern.J2EEPatterns.MVCPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 12:09
 */
public class MVCPatternDemo {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDataBase();
        StudentView studentView = new StudentView();
        StudentController controller = new StudentController(model, studentView);
        controller.updateView();
        controller.setStudentName("John");
        controller.updateView();
    }

    private static Student retrieveStudentFromDataBase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
