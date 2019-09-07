package com.libraryspringboot.services.mapper

import com.libraryspringboot.models.database.Relationship

import java.time.LocalDateTime

class RelationshipMapper {

    static Relationship mapper(Relationship relationship){

        relationship.setDateFrom(LocalDateTime.parse())

        return
    }
}
