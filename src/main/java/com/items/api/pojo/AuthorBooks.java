package com.items.api.pojo;

import java.util.List;

public class AuthorBooks {
    private String author;
    private List<String> book;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getBook() {
        return book;
    }

    public void setBook(List<String> book) {
        this.book = book;
    }
}
