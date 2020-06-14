package com.items.api.repo;


import com.items.api.entity.BookInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public interface BookRepository extends MongoRepository<BookInfo, ObjectId> {
    @Query("{title:?0}")
    BookInfo findByTitle(String title);

    @Query("{author:?0}")
    List<BookInfo> findByAuthor(String author);

    @Query("{'price':{'$gte':?0, '$lte': ?1}}")
    List<BookInfo> findByPrice(int p1, int p2);

    @Query("{'published_date':{'$gte':?0, '$lte': ?1}}")
    List<BookInfo> findByDate(LocalDate startDay, LocalDate endDate);

}
