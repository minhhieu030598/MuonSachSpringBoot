package com.libraryspringboot.services.impl

import com.libraryspringboot.models.database.Book
import com.libraryspringboot.models.database.Relationship
import com.libraryspringboot.models.database.User
import com.libraryspringboot.repositorys.BookRepository
import com.libraryspringboot.repositorys.RelationshipRepository
import com.libraryspringboot.repositorys.UserRepository
import com.libraryspringboot.services.RelationshipService
import com.libraryspringboot.services.mapper.RelationshipMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.concurrent.BlockingQueue
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue

@Service
class RelationshipSerImpl implements RelationshipService {

    @Autowired
    RelationshipRepository repository

    @Autowired
    UserRepository userRepository

    @Autowired
    BookRepository bookRepository

    @Override
    void create(List<Relationship> relationships) {

        BlockingQueue<Book> books = new LinkedBlockingQueue<>()

        bookRepository.findAllNotUse().each { book ->
            books.offer(book)
        }

        def takeABook = { User user ->
            if (books.isEmpty() || !books.size()) {
                books.wait()
            }
            Random rd = new Random()
            long timeRead = (long) 10 + rd.nextInt(300)
            LocalDateTime dateFrom = LocalDateTime.now()
            LocalDateTime dateTo = dateFrom.plus(timeRead, ChronoUnit.SECONDS)
            Relationship relationship = RelationshipMapper.mapper(user, books.poll(), dateFrom, dateTo, LocalDateTime.now())
            repository.save(relationship)
            return relationship
        }

        def updateBook = { Relationship relationship ->
            Book book = bookRepository.findById(relationship.getIdBook()).orElse(null)
            long wait = (long) LocalDateTime.now().until(relationship.getDateTo(), ChronoUnit.MILLIS)
            sleep(wait)
            books.offer(book)
            books.notifyAll()
        }

        List<User> users = userRepository.findAll().findAll {
            user -> user.getStatus() == 1
        }

        // Create a thread pool
        ExecutorService pool = Executors.newFixedThreadPool(books.size())  // 50

        users.each { user ->
            pool.submit({
                Relationship relationship = takeABook(user)
                println relationship.getIdUser() + " take " + relationship.getIdBook()
                updateBook(relationship)
            })
        }
    }
}



















