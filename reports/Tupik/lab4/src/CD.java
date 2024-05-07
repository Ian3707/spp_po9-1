import java.util.ArrayList;
import java.util.List;

public class CD {
    // Список каталогов на диске CD
    private List<Directory> directories;

    // Конструктор класса CD, инициализирует список каталогов
    public CD() {
        this.directories = new ArrayList<>();
    }

    // Внутренний класс, представляющий каталог на диске CD
    private class Directory {
        private String name;
        private List<String> files;

        // Конструктор класса Directory, инициализирует имя каталога и список файлов
        public Directory(String name) {
            this.name = name;
            this.files = new ArrayList<>();
        }

        // Метод для добавления файла в каталог
        public void addFile(String file) {
            this.files.add(file);
        }

        // Метод для вывода содержимого каталога на экран
        public void printDirectory() {
            System.out.println("Directory: " + name);
            for (String file : files) {
                System.out.println("- " + file);
            }
        }
    }

    // Метод для добавления нового каталога на диск
    public void addDirectory(String name) {
        directories.add(new Directory(name));
    }

    // Метод для добавления файла в указанный каталог
    public void addFileToDirectory(String directoryName, String fileName) {
        // Поиск каталога по имени
        for (Directory directory : directories) {
            if (directory.name.equals(directoryName)) {
                directory.addFile(fileName);
                return;
            }
        }
        System.out.println("Directory " + directoryName + " not found!");
    }

    // Метод для вывода содержимого диска на экран
    public void printCD() {
        System.out.println("CD:");
        for (Directory directory : directories) {
            directory.printDirectory();
        }
    }

    public static void main(String[] args) {
        CD cd = new CD();

        cd.addDirectory("Rihanna");
        cd.addFileToDirectory("Rihanna", "diamond.mp3");
        cd.addFileToDirectory("Rihanna", "umbrella.mp3");
        cd.addFileToDirectory("Rihanna", "work.mp3");


        cd.addDirectory("Ariana Grande");
        cd.addFileToDirectory("Ariana Grande", "7_rings.mp3");
        cd.addFileToDirectory("Ariana Grande", "dangerous_woman.mp3");

        cd.printCD();
    }
}
