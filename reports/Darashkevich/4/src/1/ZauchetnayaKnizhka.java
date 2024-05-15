import java.util.ArrayList;
import java.util.List;

public class ZauchetnayaKnizhka {
    private String studentName;
    private int studentId;
    private List<Session> sessions;

    public ZauchetnayaKnizhka(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.sessions = new ArrayList<>();
    }
    
    private class Session {
        private String semester;
        private String subjects;
        private boolean passed;

        public Session(String semester, String subjects, boolean passed) {
            this.semester = semester;
            this.subjects = subjects;
            this.passed = passed;
        }

        public String getSessionInfo() {
            return "Семестр: " + semester + ", Предметы: " + subjects + ", Сдано: " + (passed ? "Да" : "Нет");
        }
    }

    public void addSession(String semester, String subjects, boolean passed) {
        Session session = new Session(semester, subjects, passed);
        sessions.add(session);
    }

    public void displaySessions() {
        System.out.println("Информация о сессиях студента " + studentName + ":");
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("Сессия " + (i + 1) + ": " + sessions.get(i).getSessionInfo());
        }
    }

    public int getSessionCount() {
        return sessions.size();
    }

    public static void main(String[] args) {
        ZauchetnayaKnizhka studentRecord = new ZauchetnayaKnizhka("Иванов Иван", 123456);
        studentRecord.addSession("Весенний 2023", "Математика, Физика, Информатика", true);
        studentRecord.addSession("Осенний 2023", "Физика, Химия, Биология", false);
        studentRecord.addSession("Весенний 2024", "История, Литература, Обществознание", true);

        studentRecord.displaySessions();
        System.out.println("Количество сессий: " + studentRecord.getSessionCount());
    }
}
