package com.libraryspringboot.repositorys

import com.libraryspringboot.models.database.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(nativeQuery = true, value = 'SELECT * FROM books where status = 1 and is_use = 0')
    List<Book> findAllNotUse()



}