import java.util.*;

abstract class CourseType {
    private String title;
    public CourseType(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public abstract String getEvaluation();
    public String toString() {
        return title + " | " + getEvaluation();
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String title) {
        super(title);
    }
    public String getEvaluation() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }
    public String getEvaluation() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title) {
        super(title);
    }
    public String getEvaluation() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();
    public void addCourse(T course) {
        courses.add(course);
    }
    public List<T> getCourses() {
        return courses;
    }
}

class CourseDisplay {
    public static void showAll(List<? extends CourseType> list) {
        for (CourseType c : list) {
            System.out.println(c);
        }
    }
}

public class CourseManagementSystem{
    public static void main(String[] args) {
        Course<ExamCourse> examDept = new Course<>();
        Course<AssignmentCourse> assignmentDept = new Course<>();
        Course<ResearchCourse> researchDept = new Course<>();

        examDept.addCourse(new ExamCourse("Mathematics"));
        examDept.addCourse(new ExamCourse("Physics"));

        assignmentDept.addCourse(new AssignmentCourse("Computer Science"));
        assignmentDept.addCourse(new AssignmentCourse("Business Studies"));

        researchDept.addCourse(new ResearchCourse("Biotechnology"));
        researchDept.addCourse(new ResearchCourse("Astrophysics"));

        CourseDisplay.showAll(examDept.getCourses());
        CourseDisplay.showAll(assignmentDept.getCourses());
        CourseDisplay.showAll(researchDept.getCourses());
    }
}
