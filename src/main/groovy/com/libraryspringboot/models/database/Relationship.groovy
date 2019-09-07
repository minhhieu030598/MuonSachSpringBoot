package com.libraryspringboot.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity(name = "relationship")
class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id

    int idUser

    int idBook

    LocalDateTime dateFrom

    LocalDateTime dateTo

    LocalDateTime createAt

    LocalDateTime modifyAt

}
