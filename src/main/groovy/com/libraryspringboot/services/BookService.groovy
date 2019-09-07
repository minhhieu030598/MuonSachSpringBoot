package com.libraryspringboot.services

import com.libraryspringboot.models.database.Book
import com.libraryspringboot.models.system_response.MessageResponse
import org.springframework.http.ResponseEntity

interface BookService {
    List<Book> getAll()

    ResponseEntity<MessageResponse> create(List<Book> books)

    ResponseEntity<MessageResponse> delete(int id)

    ResponseEntity<MessageResponse> modify(int id, Book book)
}
