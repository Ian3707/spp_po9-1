import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Applicant> applicants;

    public Faculty(String name) {
        this.name = name;
        this.applicants = new ArrayList<>();
    }

    public void enroll(Applicant applicant) {
        applicants.add(applicant);
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public String getName() {
        return name;
    }

}
