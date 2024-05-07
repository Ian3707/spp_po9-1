import java.util.List;

public class Main {
    public static void main(String[] args) {
        EnrollmentSystem admissionSystem = new EnrollmentSystem();

        Applicant applicant1 = new Applicant("John Doe", 85.0);
        Applicant applicant2 = new Applicant("Jane Smith", 60.5);
        Applicant applicant3 = new Applicant("Alice Johnson", 65.0);
        admissionSystem.registerApplicant(applicant1);
        admissionSystem.registerApplicant(applicant2);
        admissionSystem.registerApplicant(applicant3);

        List<Applicant> admittedApplicants = admissionSystem.determineAdmittedApplicants(70.0);

        System.out.println("Admitted Applicants:");
        for (Applicant admittedApplicant : admittedApplicants) {
            System.out.println(admittedApplicant.getName());
        }
    }
}