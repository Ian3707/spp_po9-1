import java.util.ArrayList;
import java.util.List;

public class EnrollmentSystem {
    private List<Applicant> applicants;

    public EnrollmentSystem() {
        this.applicants = new ArrayList<>();
    }

    public void registerApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public List<Applicant> determineAdmittedApplicants(double passingGrade) {
        List<Applicant> admittedApplicants = new ArrayList<>();
        for (Applicant applicant : applicants) {
            if (applicant.getAverageGrade() >= passingGrade) {
                admittedApplicants.add(applicant);
            }
        }
        return admittedApplicants;
    }
}