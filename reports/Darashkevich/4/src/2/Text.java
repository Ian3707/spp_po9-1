import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Page> pages;

    public Text() {
        this.pages = new ArrayList<>();
    }

    public void addPage(Page page) {
        pages.add(page);
    }

    public void addWordToLastPage(Word word) {
        if (!pages.isEmpty()) {
            Page lastPage = pages.get(pages.size() - 1);
            lastPage.addWord(word);
        } else {
            Page newPage = new Page();
            newPage.addWord(word);
            pages.add(newPage);
        }
    }

    public String getText() {
        StringBuilder textBuilder = new StringBuilder();
        for (Page page : pages) {
            List<Word> words = page.getWords();
            for (Word word : words) {
                textBuilder.append(word.getWord()).append(" ");
            }
            textBuilder.append("\n");
        }
        return textBuilder.toString();
    }

}
