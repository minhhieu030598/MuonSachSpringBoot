package com.libraryspringboot.repositorys

import com.libraryspringboot.models.database.Relationship
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RelationshipRepository extends JpaRepository<Relationship, Integer> {

}
