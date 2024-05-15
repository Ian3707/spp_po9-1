import java.util.ArrayList;
import java.util.List;

public class EnrollmentSystem {
    public void enrollStudents(Faculty faculty) {
        List<Applicant> admittedStudents = new ArrayList<>();
        for (Applicant applicant : faculty.getApplicants()) {
            double averageGrade = applicant.getAverageGrade();
            if (averageGrade >= 60) {
                admittedStudents.add(applicant);
            }
        }
        System.out.println("Admitted students for " + faculty.getName() + ":");
        for (Applicant admittedStudent : admittedStudents) {
            System.out.println(admittedStudent.getName());
        }
    }
}

