package DesignPattern.J2EEPatterns.MVCPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 12:05
 */
public class StudentController {
    private Student model;
    private StudentView studentView;

    public StudentController(Student model, StudentView studentView) {
        this.model = model;
        this.studentView = studentView;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        studentView.printStudentDetails(model.getName(), model.getRollNo());
    }

}
