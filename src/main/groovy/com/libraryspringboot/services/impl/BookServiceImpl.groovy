package com.libraryspringboot.services.impl

import com.libraryspringboot.models.database.Book
import com.libraryspringboot.models.system_response.MessageResponse
import com.libraryspringboot.repositorys.BookRepository
import com.libraryspringboot.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository

    @Override
    List<Book> getAll() {
        List<Book> books = repository.findAll()
        return books.findAll{book -> book.getStatus() == 1}
    }

    @Override
    ResponseEntity<MessageResponse> create(List<Book> books) {
        books.each { book ->
            repository.save(book)
        }
        return new ResponseEntity<>(MessageResponse.data.get("inserted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<MessageResponse> delete(int id) {
        Book book = repository.findById(id).orElse(null)
        book.setStatus(0)
        repository.save(book)
        return new ResponseEntity<>(MessageResponse.data.get("deleted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<MessageResponse> modify(int id, Book book) {
        repository.save(book)
        return new ResponseEntity<>(MessageResponse.data.get("updated"), HttpStatus.OK)
    }
}
