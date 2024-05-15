package Lab6_1;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Teacher {
    private static Teacher instance;
    private List<Student> students;

    private Teacher() {
        students = new ArrayList<>();
    }

    public static Teacher getInstance() {
        if (instance == null) {
            instance = new Teacher();
        }
        return instance;
    }

    public void checkLabWork(Student student) {
        System.out.println("Преподаватель проверяет лабораторную работу студента " + student.getName());
    }

    public void conductConsultation(Student student) {
        System.out.println("Преподаватель проводит консультацию со студентом " + student.getName());
    }

    public void takeExam(Student student) {
        System.out.println("Преподаватель принимает экзамен у студента " + student.getName());
    }

    public void gradeStudent(Student student) {
        System.out.println("Преподаватель выставляет отметку студенту " + student.getName());
    }

    public void conductLecture() {
        System.out.println("Преподаватель проводит лекцию");
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}

public class Lab6_1 {
    public static void main(String[] args) {
        Teacher teacher = Teacher.getInstance();

        Student student1 = new Student("Иванов");
        Student student2 = new Student("Петров");
        Student student3 = new Student("Сидоров");

        teacher.addStudent(student1);
        teacher.addStudent(student2);
        teacher.addStudent(student3);

        for (Student student : teacher.getStudents()) {
            teacher.checkLabWork(student);
            teacher.conductConsultation(student);
            teacher.takeExam(student);
            teacher.gradeStudent(student);
        }

        teacher.conductLecture();
    }
}
