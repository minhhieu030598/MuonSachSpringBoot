package com.libraryspringboot.services.mapper

import com.libraryspringboot.models.database.Book
import com.libraryspringboot.models.database.Relationship
import com.libraryspringboot.models.database.User

import java.time.LocalDateTime

class RelationshipMapper {

    static Relationship mapper(User user, Book book, LocalDateTime dateFrom, LocalDateTime dateTo, LocalDateTime createAt) {
        return new Relationship(user.getId(), book.getId(),
                dateFrom, dateTo, createAt)
    }


}
