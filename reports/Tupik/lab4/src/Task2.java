import java.util.ArrayList;
import java.util.List;

class Paragraph {
    // Содержание абзаца
    private String content;

    // Конструктор для инициализации содержания абзаца
    public Paragraph(String content) {
        this.content = content;
    }

    // Метод для получения содержания абзаца
    public String getContent() {
        return content;
    }

    //Метод для установки содержания абзаца
    public void setContent(String content) {
        this.content = content;
    }

    // Метод для подсчета количества слов в абзаце
    public int countWords() {
        String[] words = content.split("\\s+");
        return words.length;
    }
}

class Text {
    //Список абзацев
    private List<Paragraph> paragraphs;

    //Конструктор для инициализации списка абзацев
    public Text() {
        this.paragraphs = new ArrayList<>();
    }

    // Метод для добавления абзаца в текст
    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    // Метод для удаления абзаца из текста
    public void removeParagraph(Paragraph paragraph) {
        paragraphs.remove(paragraph);
    }

    // Метод для подсчета количества абзацев в тексте
    public int countParagraphs() {
        return paragraphs.size();
    }

    // Метод для подсчета общего количества слов в тексте
    public int countWords() {
        int totalWords = 0;
        for (Paragraph paragraph : paragraphs) {
            totalWords += paragraph.countWords();
        }
        return totalWords;
    }

    // Метод для отображения содержимого текста
    public void display() {
        for (Paragraph paragraph : paragraphs) {
            System.out.println(paragraph.getContent());
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        Paragraph paragraph1 = new Paragraph("Я помню чудное мгновенье:");
        Paragraph paragraph2 = new Paragraph("Передо мной явилась ты,");
        Paragraph paragraph3 = new Paragraph("Как мимолетное виденье,");
        Paragraph paragraph4 = new Paragraph("Как гений чистой красоты.");

        Text text = new Text();
        text.addParagraph(paragraph1);
        text.addParagraph(paragraph2);
        text.addParagraph(paragraph3);
        text.addParagraph(paragraph4);

        System.out.println("Количество абзацев: " + text.countParagraphs());
        System.out.println("Количество слов: " + text.countWords());

        System.out.println("Содержимое текста:");
        text.display();
    }
}