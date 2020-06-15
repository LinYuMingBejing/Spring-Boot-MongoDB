package com.items.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;


public class AuthorBooks implements Serializable {
    private String author;
    private List<String> book;

    public AuthorBooks() {
    }

    public AuthorBooks(String author, List<String> book) {
        this.author = author;
        this.book = book;
    }

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
