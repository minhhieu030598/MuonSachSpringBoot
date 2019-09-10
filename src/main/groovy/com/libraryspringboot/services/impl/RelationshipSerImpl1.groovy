//package com.libraryspringboot.services.impl
//
//import com.libraryspringboot.models.database.Book
//import com.libraryspringboot.models.database.Relationship
//import com.libraryspringboot.models.database.User
//import com.libraryspringboot.models.system_response.MessageResponse
//import com.libraryspringboot.repositorys.BookRepository
//import com.libraryspringboot.repositorys.RelationshipRepository
//import com.libraryspringboot.repositorys.UserRepository
//import com.libraryspringboot.services.RelationshipService
//import com.libraryspringboot.services.mapper.RelationshipMapper
//import com.libraryspringboot.untils.RandomTime
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.stereotype.Service
//
//import java.time.LocalDateTime
//import java.time.temporal.ChronoUnit
//import java.util.concurrent.BlockingQueue
//import java.util.concurrent.ExecutorService
//import java.util.concurrent.Executors
//import java.util.concurrent.LinkedBlockingDeque
//import java.util.concurrent.TimeUnit
//
//@Service
//class RelationshipSerImpl implements RelationshipService {
//
//    @Autowired
//    RelationshipRepository repository
//
//    @Autowired
//    UserRepository userRepository
//
//    @Autowired
//    BookRepository bookRepository
//
////    private void updateBookNotUse() {
////        Thread thread = new Thread(new Runnable() {
////            @Override
////            void run() {
////                bookRepository.findAllNotUse().each { book ->
////                    books.contains(book) ? {} : books.push(book)
////                }
////            }
////        })
////
////        thread.start()
////        thread.join()
////    }
//
//    @Override
//    ResponseEntity<MessageResponse> create(List<Relationship> relationships) {
////        relationships.each {relationship ->
////            repository.save(relationship)
////        }
////        return new ResponseEntity<>(MessageResponse.data.get("inserted"), HttpStatus.OK)
//
////        LinkedList<User> users = userRepository.findAll() as LinkedList<User>
////        while(users.isEmpty()){
////
////        }
//
// //   }
//        List<Book> books = new LinkedList<>()
//
//        bookRepository.findAllNotUse().each { book ->
//            books.contains(book) ? {} : books.push(book)
//        }
//
//        def takeBook = {
//
//        }
//
//
//        // Continuously (1s) update unused books in the database
//        bookRepository.findAllNotUse().each { book ->
//            books.contains(book) ? {} : books.push(book)
//        }
//
//        // Create a thread pool
//        ExecutorService pool = Executors.newFixedThreadPool(50)
//
//        // body code
//        List<User> users = userRepository.findAll().findAll {
//            user -> user.getStatus() == 1
//        }
//        users.each { user ->
//            if (!books.isEmpty()) {
//                Book book = books.pop()
//                pool.execute(new RunThread(book, user))
//            }/*else{
//                bookRepository.findAllNotUse().each { book ->
//                    books.contains(book) ? {} : books.push(book)
//                }
//            }*/
//        }
//
//        // time for Thread pool is life if haven't done
//        pool.awaitTermination(3, TimeUnit.SECONDS)
//
//
////        while (true) {
//        // check timeTo compare to now for upadating unused books in the database
//
////            // Continuously (1s) update unused books in the database
////            bookRepository.findAllNotUse().each { book ->
////                books.contains(book) ? {} : books.push(book)
////            }
////            println books.size()
////            Thread.sleep(2000)
////        }
//
//
//        return null
//    }
//
//
//}
//
//class RunThread implements Runnable {
//
//    Book book
//    User user
//
//    @Override
//    void run() {
//        LocalDateTime dateFrom = LocalDateTime.now()
//        LocalDateTime dateTo = dateFrom.plus(RandomTime.getRandom(), ChronoUnit.SECONDS)
//        synchronized (book) {
//            Relationship relationship = RelationshipMapper.mapper(user, book, dateFrom, dateTo, LocalDateTime.now())
//            println 'Sách ' + book.getId() + ' được người ' + user.getId() + ' mượn.'
//        }
//    }
//
//    RunThread(Book book, User user) {
//        this.book = book
//        this.user = user
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
