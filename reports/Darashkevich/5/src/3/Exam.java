abstract class Exam {
    private String name;

    public Exam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void conductExam();

    public abstract void gradeExam(Applicant applicant);
}
