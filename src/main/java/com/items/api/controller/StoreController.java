package com.items.api.controller;


import com.items.api.pojo.AuthorBooks;
import com.items.api.pojo.AuthorBooksResponse;
import com.items.api.pojo.BookDateResponse;
import com.items.api.pojo.BookPriceResponse;
import com.items.api.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    @Autowired
    CacheManager cacheManager;

    @ResponseBody
    @GetMapping("/book/price")
    Callable<BookPriceResponse> findPrice(@RequestParam String title){
        return()->{
            return storeService.findPriceByTitle(title);
        };
    }

    @ResponseBody
    @GetMapping("/author/book")
    Callable<AuthorBooksResponse> findBooks(@RequestParam String author){
        return ()->{
            AuthorBooks authorBooks =  storeService.findBookByAuthor(author);
            return AuthorBooksResponse.data(authorBooks);
        };
    }

    @ResponseBody
    @GetMapping("/book/find/price/")
    Callable<BookPriceResponse> getBookByPrice(@RequestParam int lowPrice, int highPrice){
        return()->{
            return storeService.findBookByPrice(lowPrice, highPrice);
        };
    }

    @ResponseBody
    @GetMapping("/book/date")
    Callable<BookDateResponse> getBookByDate(@RequestParam String startDate, String endDate){
        return()->{
            return storeService.findBookByDate(startDate, endDate);
        };
    }
}
