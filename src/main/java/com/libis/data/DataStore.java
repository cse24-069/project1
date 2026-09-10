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

        // 10 Psychology Books
        BOOKS.add(new Book(101, "Thinking, Fast and Slow", "Daniel Kahneman", "Cognitive Psychology", "An exploration of the two systems that drive the way we think: System 1 is fast and intuitive, System 2 is slower and more deliberate.", true));
        BOOKS.add(new Book(102, "Man's Search for Meaning", "Viktor E. Frankl", "Existential Psychology", "A psychiatrist's memoir of life in Nazi death camps and its lessons for spiritual survival, founding the school of logotherapy.", true));
        BOOKS.add(new Book(103, "The Interpretation of Dreams", "Sigmund Freud", "Psychoanalysis", "Freud's groundbreaking work introducing his theory of the unconscious and dream analysis as the 'royal road' to the mind.", false));
        BOOKS.add(new Book(104, "Influence: The Psychology of Persuasion", "Robert B. Cialdini", "Social Psychology", "A deep dive into the six universal principles of persuasion and how they are used to influence human behavior.", true));
        BOOKS.add(new Book(105, "The Man Who Mistook His Wife for a Hat", "Oliver Sacks", "Clinical Psychology", "A collection of case studies of patients with neurological disorders, exploring the bizarre and fascinating workings of the brain.", true));
        BOOKS.add(new Book(106, "Flow: The Psychology of Optimal Experience", "Mihaly Csikszentmihalyi", "Positive Psychology", "A look at the state of 'flow'—the completely focused, energized mental state where we are fully immersed in an activity.", false));
        BOOKS.add(new Book(107, "Predictably Irrational", "Dan Ariely", "Behavioral Economics", "An exploration of the hidden forces that shape our decisions and why we consistently make irrational choices in predictable ways.", true));
        BOOKS.add(new Book(108, "The Body Keeps the Score", "Bessel van der Kolk", "Trauma Psychology", "A pioneering researcher's look at how trauma literally reshapes both body and brain, and how to heal from it.", true));
        BOOKS.add(new Book(109, "Grit: The Power of Passion and Perseverance", "Angela Duckworth", "Personality Psychology", "Explaining why talent is not the only key to success, and how a combination of passion and perseverance (grit) matters more.", true));
        BOOKS.add(new Book(110, "The Social Animal", "Elliot Aronson", "Social Psychology", "A classic text exploring how our thoughts, feelings, and behaviors are influenced by the actual, imagined, or implied presence of others.", true));
    }
}