package com.libraryspringboot.repositorys

import com.libraryspringboot.models.form_show.FormRelationship
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FormRelationshipRepository extends JpaRepository<FormRelationship, Integer > {

    @Query(nativeQuery = true,
            value = 'select relationship.id, id_book, id_user, books.name as book_name, users.name as user_name, date_from, date_to, create_at, modify_at from relationship join books on relationship.id_book = books.id join users on relationship.id_user = users.id')
    List<FormRelationship> getAll(Pageable pageable)

}
