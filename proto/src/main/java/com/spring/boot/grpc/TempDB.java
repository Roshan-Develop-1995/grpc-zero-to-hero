package com.spring.boot.grpc;

import java.util.ArrayList;
import java.util.List;

public class TempDB {

    public static List<Author> getAuthorsFromTempDB(){
        return new ArrayList<>(){
            {
                add(Author.newBuilder().setAuthorId(1).setBookId(1).setFirstName("Charles").setLastName("Dickens").build());
                add(Author.newBuilder().setAuthorId(2).setBookId(2).setFirstName("William").setLastName("Shakespeare").build());
            }
        };
    }

    public static List<Book> getBooksFromTempDB(){
        return new ArrayList<>(){
            {
                add(Book.newBuilder().setAuthorId(1).setBookId(1).setTitle("Oliver Twist").setPrice(123.3f).setPages(230).build());
                add(Book.newBuilder().setAuthorId(2).setBookId(2).setTitle("As You like it").setPrice(143.3f).setPages(430).build());
            }
        };
    }
}
