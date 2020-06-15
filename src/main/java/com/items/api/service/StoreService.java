package com.items.api.service;

import com.items.api.entity.BookInfo;
import com.items.api.pojo.AuthorBooks;
import com.items.api.pojo.BookDateResponse;
import com.items.api.pojo.BookPriceResponse;
import com.items.api.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
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
    public BookPriceResponse findPriceByTitle(String title){
        BookInfo book = bookRepository.findByTitle(title);
        BookPriceResponse bookPriceResponse = new BookPriceResponse();
        Map<String,Integer> PriceMap =  new HashMap<>();
        PriceMap.put(title, book.getPrice());
        System.out.println(PriceMap);
        System.out.println("---->");
        return bookPriceResponse.data(PriceMap);
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
    public BookPriceResponse findBookByPrice(int p1, int p2){
        BookPriceResponse response = new BookPriceResponse<>();
        if (p1>p2){
            response.setStatus(false);
            response.setMsg("錯誤:起始價格大於最終價格");
            return response;
        }
        List<BookInfo> books = bookRepository.findByPrice(p1,p2, PageRequest.of(0, 100));
        response.setData(books);
        return response;
    }

    @Cacheable("Date")
    public BookDateResponse findBookByDate(String startDate, String endDate){
        LocalDate start_date = LocalDate.parse(startDate, DATE_TIME_FORMATTER);
        LocalDate end_date = LocalDate.parse(endDate, DATE_TIME_FORMATTER);
        BookDateResponse response = new BookDateResponse();
        if (start_date.isAfter(end_date)){
            response.setStatus(false);
            response.setMsg("錯誤:起始日期大於結束日期");
            return response;
        }
        List<BookInfo> books = bookRepository.findByDate(start_date, end_date);
        response.setData(books);
        response.setStatus(true);
        return response;
    }
}
