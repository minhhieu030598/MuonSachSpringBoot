package com.libraryspringboot.repositorys

import com.libraryspringboot.models.database.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository extends JpaRepository<Book, Integer> {

}
