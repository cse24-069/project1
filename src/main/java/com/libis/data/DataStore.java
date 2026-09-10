package com.libis.data;

import com.libis.model.Book;
import com.libis.model.Member;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public static final List<Member> MEMBERS = new ArrayList<>();
    public static final List<Book> BOOKS = new ArrayList<>();

    static {
        // 5 Members
        MEMBERS.add(new Member(1, "Festus", "Ntala", "NtalaF@libis.com", "pass123"));
        MEMBERS.add(new Member(2, "Jane", "Mokoro", "jane@libis.com", "pass456"));
        MEMBERS.add(new Member(3, "Alice", "Mokoena", "alice@libis.com", "alice789"));
        MEMBERS.add(new Member(4, "Bob", "Titus", "bob@libis.com", "bob101"));
        MEMBERS.add(new Member(5, "Charlie", "Mosimakoko", "charlie@libis.com", "charlie202"));

        // 10 Books
        BOOKS.add(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", "A story of the fabulously wealthy Jay Gatsby...", true));
        BOOKS.add(new Book(102, "1984", "George Orwell", "Dystopian", "Winston Smith wrestles with oppression in Oceania...", true));
        BOOKS.add(new Book(103, "To Kill a Mockingbird", "Harper Lee", "Fiction", "The story of racial injustice and the loss of innocence...", false));
        BOOKS.add(new Book(104, "The Hobbit", "J.R.R. Tolkien", "Fantasy", "Bilbo Baggins goes on an adventure to win a share of the treasure...", true));
        BOOKS.add(new Book(105, "Pride and Prejudice", "Jane Austen", "Romance", "The turbulent relationship between Elizabeth Bennet and Mr. Darcy...", true));
        BOOKS.add(new Book(106, "The Catcher in the Rye", "J.D. Salinger", "Fiction", "Holden Caulfield's experiences in New York City...", false));
        BOOKS.add(new Book(107, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "The epic quest to destroy the One Ring...", true));
        BOOKS.add(new Book(108, "Animal Farm", "George Orwell", "Allegory", "A group of farm animals rebel against their human farmer...", true));
        BOOKS.add(new Book(109, "Brave New World", "Aldous Huxley", "Dystopian", "A futuristic society engineered for stability and control...", true));
        BOOKS.add(new Book(110, "The Alchemist", "Paulo Coelho", "Adventure", "Santiago's journey to find worldly treasure...", true));
    }
}