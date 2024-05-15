import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
public class Library {
    private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book){
        if (!books.contains(book))
            books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }
    public Book borrowBook(Book book, String reader){
        if (books.contains(book)){
            int bookBorrowingDays = 30;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR, bookBorrowingDays);
            return book.borrowBook(reader, calendar.getTime());
        }
        else return null;
    }
    public void returnBookToLibrary(Book book, String reader){
        if (books.contains(book)){
            book.returnBook(reader);
        }
    }
    public ArrayList<Book> getAllBooks() {
        return books;
    }
    public ArrayList<Book> getBooksOlderThan(int year) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books)
            if (book.getPublicationYear() <
                    Calendar.getInstance().get(Calendar.YEAR) - year)
                result.add(book);
        return result;
    }
    public ArrayList<Book> getBooksOnLoan() {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (!book.getBorrowedBooks().isEmpty()) {
                result.add(book);
            }
        }
        return result;
    }
    public ArrayList<Book> getOverdueBooks() {
        ArrayList<Book> result = new ArrayList<>();
        Date date = new Date();
        for (Book book : books)
            for (Map.Entry<String, Date> entry :
                    book.getBorrowedBooks().entrySet())
                if (entry.getValue().after(date)){
                    result.add(book);
                    break;
                }
        return result;
    }
    public Book getFirstBookByTitle(String title){
        for (Book book : books)
            if (book.getTitle().equals(title))
                return book;
        return null;
    }
}