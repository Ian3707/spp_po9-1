public class University implements EducationalInstitution {
    @Override
    public void addStudent(String studentName) {
        System.out.println("Студент " + studentName + " добавлен в университет.");
    }

    @Override
    public void removeStudent(String studentName) {
        System.out.println("Студент " + studentName + " удален из университета.");
    }

    @Override
    public void getStudentInfo() {
        System.out.println("Информация о студентах в университете:");
    }
}
