package com.libraryspringboot.repositorys

import com.libraryspringboot.models.database.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends JpaRepository<User, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM library.users limit ?0")
    List<User> getLimit(int limit)
}
