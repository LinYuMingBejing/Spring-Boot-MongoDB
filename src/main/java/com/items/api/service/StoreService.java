package com.items.api.service;

import com.items.api.entity.BookInfo;
import com.items.api.pojo.AuthorBooks;
import com.items.api.pojo.BookDateResponse;
import com.items.api.pojo.BookPrice;
import com.items.api.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    private BookRepository bookRepository;

    @Cacheable("Book")
    public BookPrice findPriceByTitle(String title){
        BookInfo book = bookRepository.findByTitle(title);
        BookPrice bookPrice = new BookPrice();
        bookPrice.setPrice(book.getPrice());
        bookPrice.setTitle(book.getTitle());
        return bookPrice;
    }

    @Cacheable("Author")
    public AuthorBooks findBookByAuthor(String author){
        List<BookInfo> books = bookRepository.findByAuthor(author);
        List<String> book = books.stream().map(s->s.getTitle()).collect(Collectors.toList());
        AuthorBooks authorBooks = new AuthorBooks();
        authorBooks.setBook(book);
        authorBooks.setAuthor(author);
        return authorBooks;
    }

    @Cacheable("Price")
    public List<HashMap<String,Object>> findBookByPrice(int p1, int p2){
        List<BookInfo> books = bookRepository.findByPrice(p1,p2);
        System.out.println(books);
        Map bookMap = new HashMap();
        List reusltList = new ArrayList<>();
        for(BookInfo book : books){
            bookMap.put(book.getTitle(),book.getPrice());
            reusltList.add(bookMap);
        }
        return reusltList;
    }

    @Cacheable("Date")
    public BookDateResponse findBookByDate(String startDate, String endDate){
        LocalDate start_date = LocalDate.parse(startDate, DATE_TIME_FORMATTER);
        LocalDate end_date = LocalDate.parse(endDate, DATE_TIME_FORMATTER);
        BookDateResponse response = new BookDateResponse();
        if (start_date.isAfter(end_date)){
            response.setStatus(false);
            response.setMsg("起始日期大於結束日期");
            return response;
        }
        List<BookInfo> books = bookRepository.findByDate(start_date, end_date);
        response.setData(books);
        response.setStatus(true);
        return response;
    }
}
