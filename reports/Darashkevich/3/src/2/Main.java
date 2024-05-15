public class Main {
    public static void main(String[] args) throws Exception {
        Library library = new Library();
        Book book1 = new Book("978-0061120084", "J.K. Rowling",
                "Harry Potter and the Philosopher's Stone",
                2024, 223, 1, 1);
        Book book2 = new Book("978-0439554930", "J.K. Rowling",
                "Harry Potter and the Chamber of Secrets",
                1998, 251, 3, 2);
        Book book3 = new Book("978-0439064866", "J.K. Rowling",
                "Harry Potter and the Prisoner of Azkaban",
                1999, 317, 6, 1);
        Book book4 = new Book("978-0439136365", "J.K. Rowling",
                "Harry Potter and the Goblet of Fire",
                2000, 636, 5, 2);
        Book book5 = new Book("978-0439358071", "J.K. Rowling",
                "Harry Potter and the Order of the Phoenix",
                2003, 870, 2, 1);
        Book book6 = new Book("978-0439784542", "J.K. Rowling",
                "Harry Potter and the Half-Blood Prince",
                2005, 652, 4, 1);
        Book book7 = new Book("978-0545010221", "J.K. Rowling",
                "Harry Potter and the Deathly Hallows",
                2024, 759, 3, 2);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);

        System.out.println("All books:");
        for (Book bk : library.getAllBooks()){
            System.out.println(bk);
        }

        System.out.println("\nBooks on loan:");
        library.borrowBook(book1, "John");
        library.borrowBook(book3, "Emma");
        library.borrowBook(book6, "David");
        for (Book bk : library.getBooksOnLoan()){
            System.out.println(bk);
        }

        System.out.println("\nBooks older than 5 years:");
        for (Book bk : library.getBooksOlderThan(5)){
            System.out.println(bk);
        }
    }
}