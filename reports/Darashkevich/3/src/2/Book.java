import java.util.Date;
import java.util.HashMap;
class Book {
    private String udcCode;
    private String author;
    private String title;
    private int publicationYear;
    private int pagesCount;
    private int volumesCount;
    private int copiesCount;
    private HashMap<String, Date> borrowedBooks;
    public Book(String udkNumber, String author, String title, int publicationYear,
                int pageCount, int volumesCount, int copiesCount) {
        this.udcCode = udkNumber;
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pagesCount = pageCount;
        this.volumesCount = volumesCount;
        this.copiesCount = copiesCount;
        this.borrowedBooks = new HashMap<>();
    }
    public String getUdcCode() {
        return udcCode;
    }
    public void setUdcCode(String udcCode) {
        if (udcCode != null && !udcCode.isEmpty()){
            this.udcCode = udcCode;
        }
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()){
            this.author = author;
        }
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title != null && !title.isEmpty()){
            this.title = title;
        }
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        if (publicationYear > 0){
            this.publicationYear = publicationYear;
        }
    }
    public int getPagesCount() {
        return pagesCount;
    }
    public void setPagesCount(int pagesCount) {
        if (pagesCount > 0){
            this.pagesCount = pagesCount;
        }
    }
    public int getVolumesCount() {
        return volumesCount;
    }
    public void setVolumesCount(int volumesCount) {
        if (volumesCount > 0){
            this.volumesCount = volumesCount;
        }
    }
    public int getCopiesCount() {
        return copiesCount;
    }
    public void setCopiesCount(int copiesCount) {
        if (copiesCount > 0){
            this.copiesCount = copiesCount;
        }
    }
    @Override
    public String toString() {
        StringBuilder readers = new StringBuilder();
        if (!borrowedBooks.isEmpty()){
            readers.append(", readers( ");
            borrowedBooks.forEach((readerName, deadline) -> {
                readers.append(readerName).append(", ").append(deadline).append(";");
            });
            readers.append(")");
        }
        return "book(" +
                "udkNumber = " + udcCode +
                ", author = " + author +
                ", title = " + title +
                ", publicationYear = " + publicationYear +
                ", pageCount = " + pagesCount +
                ", volumesCount = " + volumesCount +
                ", copiesCount = " + copiesCount +
                readers + ")";
    }
    public Book borrowBook(String reader, Date deadline){
        if (reader != null && deadline != null && copiesCount >= 1){
            copiesCount--;
            borrowedBooks.put(reader, deadline);
            return this;
        }
        else return null;
    }
    public void returnBook(String reader){
        borrowedBooks.remove(reader);
    }
    public HashMap<String, Date> getBorrowedBooks(){
        return borrowedBooks;
    }
}