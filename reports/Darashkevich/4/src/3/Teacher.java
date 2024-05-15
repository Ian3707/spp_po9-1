public class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void grade(Applicant applicant, Exam exam, int grade) {
        applicant.takeExam(exam, grade);
    }
}
