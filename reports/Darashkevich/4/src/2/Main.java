public class Main {
    public static void main(String[] args) {
        Text text = new Text();

        Word hello = new Word("Hello");
        Word world = new Word("world");
        Word java = new Word("Java");

        Page page1 = new Page();
        page1.addWord(hello);
        page1.addWord(world);
        text.addPage(page1);

        Page page2 = new Page();
        page2.addWord(java);
        text.addPage(page2);

        System.out.println(text.getText());
    }
}
