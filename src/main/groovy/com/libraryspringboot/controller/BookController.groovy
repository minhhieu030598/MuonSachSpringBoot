package com.libraryspringboot.controller

import com.libraryspringboot.models.database.Book
import com.libraryspringboot.models.system_response.MessageResponse
import com.libraryspringboot.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    BookService service

    @GetMapping
    List<Book> get(){
        return service.findAll()
    }

    @PostMapping
    ResponseEntity<MessageResponse> create(@RequestBody List<Book> books){
        return service.create(books)
    }

    @PatchMapping("/{id}")
    ResponseEntity<MessageResponse> delete(@PathVariable int id ){
        return service.delete(id)
    }

    @PutMapping("/{id}")
    ResponseEntity<MessageResponse> modify(@PathVariable int id, @RequestBody Book book ){
        return service.modify(id, book )
    }
}
