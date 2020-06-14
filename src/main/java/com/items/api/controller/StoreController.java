package com.items.api.controller;


import com.items.api.entity.BookInfo;
import com.items.api.pojo.AuthorBooks;
import com.items.api.pojo.BookPrice;
import com.items.api.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    @Autowired
    CacheManager cacheManager;

    @ResponseBody
    @GetMapping("/book/price")
    private BookPrice findPrice(@RequestParam String title){
        return storeService.findPriceByTitle(title);
    }

    @ResponseBody
    @GetMapping("/author/book")
    private AuthorBooks findBooks(@RequestParam String author){
        return storeService.findBookByAuthor(author);
    }

    @ResponseBody
    @GetMapping("/book/find/price/")
    private List<HashMap<String,Object>> getBookByPrice(@RequestParam int p1, int p2){
        return storeService.findBookByPrice(p1,p2);
    }

    @ResponseBody
    @GetMapping("/book/date")
    private Object getBookByDate(@RequestParam String startDate, String endDate){
        return storeService.findBookByDate(startDate, endDate);
    }
}
