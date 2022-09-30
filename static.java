package Homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1)	Given a database table “Book” with columns (id, isbn, name, author, publish date), 
 * define a java class that matches this table and then use a static block to initialize this table with some records.
 * 
 * 2)	Define a Java class “BookSeller” and then define a static inner class “Book”, and use a static method “sellBooks” 
 * to initialize several books, and in the main method display all the books by calling the “sellBooks” method.
 */
public class staticTopics {

    public static class Books {
        public int id, isbn;
        public String name, author, publish_date;
        public Books(int id, int isbn, String name, String author, String publish_date) {
            this.id = id;
            this.isbn = isbn;
            this.name = name;
            this.author = author;
            this.publish_date = publish_date;
        }
    }

    public class matchTables {
        private static List<Books> database = new ArrayList<>();
        static {
            database.add(new Books(0, 0001, "name1", "author1", "publish_date1"));
            database.add(new Books(1, 0002, "name2", "author2", "publish_date2"));
        }
        public static void main(String[] args) {
            System.out.println(database);
        }
    }

    public class BookSeller {
        static List<String> Book = new ArrayList<>();
        static {
            Book.add("book1");
            Book.add("book2");
        }

        public static void sellBooks(List<String> book) {
            System.out.println(Book);
        }

        public static void main(String[] args) {
            sellBooks(Book);
        }
    }
}
