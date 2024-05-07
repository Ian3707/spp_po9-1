import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("Computer Science");

        Applicant applicant1 = new Applicant("John", faculty);
        Applicant applicant2 = new Applicant("Alice", faculty);

        Exam mathExam = new Exam("Math", LocalDate.of(2024, 6, 1));
        Exam englishExam = new Exam("English", LocalDate.of(2024, 6, 2));
        applicant1.registerForExam(mathExam);
        applicant1.registerForExam(englishExam);
        applicant2.registerForExam(mathExam);

        Teacher teacher = new Teacher("Dr. Smith");

        teacher.grade(applicant1, mathExam, 70);
        teacher.grade(applicant1, englishExam, 80);
        teacher.grade(applicant2, mathExam, 55);

        faculty.enroll(applicant1);
        faculty.enroll(applicant2);

        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();
        enrollmentSystem.enrollStudents(faculty);
    }
}

