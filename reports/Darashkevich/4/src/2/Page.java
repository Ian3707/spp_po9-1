import java.util.ArrayList;
import java.util.List;

public class Page {
    private List<Word> words;

    public Page() {
        this.words = new ArrayList<>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public List<Word> getWords() {
        return words;
    }
}
