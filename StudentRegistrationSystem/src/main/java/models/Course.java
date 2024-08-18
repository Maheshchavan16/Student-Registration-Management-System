import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private String instructor;
    private int maxCapacity;
    private List<Student> enrolledStudents;
    private Map<Student, Double> gradebook;
    private Map<Student, Boolean> attendance;

    public Course(String courseId, String courseName, String instructor, int maxCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
        this.gradebook = new HashMap<>();
        this.attendance = new HashMap<>();
    }
    // Getters and setters

    public void addGrade(Student student, double grade) {
        gradebook.put(student, grade);
    }

    public Double getGrade(Student student) {
        return gradebook.get(student);
    }

    public void updateGrade(Student student, double newGrade) {
        gradebook.put(student, newGrade);
        {
            if (gradebook.containsKey(student)) {
                gradebook.put(student, newGrade);
            } else {
                System.out.println("Student not found in gradebook.");
            }
        }
    }

    public void removeGrade(Student student) {
        gradebook.remove(student);
    }

    // Getters and setters

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            return true;
        } else {
            return false; // Course is full
        }
    }

    public boolean removeStudent(Student student) {
        return enrolledStudents.remove(student);
    }

    public void markAttendance(Student student, boolean present) {
        attendance.put(student, present);
    }

    public Boolean getAttendance(Student student) {
        return attendance.get(student);
    }
}
