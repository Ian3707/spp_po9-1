import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Applicant {
    private String name;
    private Faculty faculty;
    private List<Exam> exams;
    private Map<Exam, Integer> grades;

    public Applicant(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
        this.exams = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public void registerForExam(Exam exam) {
        exams.add(exam);
    }

    public void takeExam(Exam exam, int grade) {
        if (exams.contains(exam)) {
            grades.put(exam, grade);
        } else {
            System.out.println("Error: This applicant is not registered for the exam.");
        }
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public String getName() {
        return name;
    }

}
