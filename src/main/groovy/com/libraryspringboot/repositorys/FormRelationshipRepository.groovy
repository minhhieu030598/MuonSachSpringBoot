package com.libraryspringboot.repositorys

import com.libraryspringboot.models.form_show.FormRelationship
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FormRelationshipRepository extends JpaRepository<FormRelationship, Integer > {

    @Query(nativeQuery = true,
            value = 'select relationship.id, id_book, id_user, books.name as book_name, users.name as user_name, date_from, date_to, create_at, modify_at from relationship join books on relationship.id_book = books.id join users on relationship.id_user = users.id')
    List<FormRelationship> getAll()

    @Query(nativeQuery = true,
            value = 'select relationship.id, id_book, id_user, books.name as book_name, users.name as user_name, date_from, date_to, create_at, modify_at from relationship join books on relationship.id_book = books.id join users on relationship.id_user = users.id limit 20;')
    List<FormRelationship> getLimit(Pageable pageable)

    @Query(nativeQuery = true,
            value = 'select relationship.id, id_book, id_user, books.name as book_name, users.name as user_name, date_from, date_to, create_at, modify_at from relationship join books on relationship.id_book = books.id join users on relationship.id_user = users.id')
    List<FormRelationship> findAllData()

    @Query(nativeQuery = true,
            value ='select relationship.id, id_book, id_user, books.name as book_name, users.name as user_name, date_from, date_to, create_at, modify_at from relationship join books on relationship.id_book = books.id join users on relationship.id_user = users.id where id_book = ?0')
    List<FormRelationship> getByBookId(int idBook)

    @Query(nativeQuery = true,
            value ='select relationship.id, id_book, id_user, books.name as book_name, users.name as user_name, date_from, date_to, create_at, modify_at from relationship join books on relationship.id_book = books.id join users on relationship.id_user = users.id where id_user = ?0')
    List<FormRelationship> getByUserId(int idUser)

}
