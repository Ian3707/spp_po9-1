public class College implements EducationalInstitution {
    @Override
    public void addStudent(String studentName) {
        System.out.println("Студент " + studentName + " добавлен в колледж.");
    }

    @Override
    public void removeStudent(String studentName) {
        System.out.println("Студент " + studentName + " удален из колледжа.");
    }

    @Override
    public void getStudentInfo() {
        System.out.println("Информация о студентах в колледже:");
    }
}
