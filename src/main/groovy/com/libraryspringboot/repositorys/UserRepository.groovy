package com.libraryspringboot.repositorys

import com.libraryspringboot.models.database.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends JpaRepository<User, Integer> {
}
