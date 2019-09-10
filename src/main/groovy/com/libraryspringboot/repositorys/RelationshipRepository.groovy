package com.libraryspringboot.repositorys

import com.libraryspringboot.models.database.Relationship
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RelationshipRepository extends JpaRepository<Relationship, Integer> {

    @Query(nativeQuery= true, value = 'select *  from library.relationship Where date_to >= now() order by relationship.date_to limit 1')
    Relationship getRecordNearest()

}
