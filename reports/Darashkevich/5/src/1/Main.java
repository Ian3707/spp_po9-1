public class Main {
    public static void main(String[] args) {
        College college = new College();

        college.addStudent("Иванов");
        college.addStudent("Петров");
        college.addStudent("Сидоров");

        college.getStudentInfo();

        college.removeStudent("Петров");

        college.getStudentInfo();

        University university = new University();

        university.addStudent("Козлов");
        university.addStudent("Михайлов");

        university.getStudentInfo();

        university.removeStudent("Михайлов");

        university.getStudentInfo();
    }
}
