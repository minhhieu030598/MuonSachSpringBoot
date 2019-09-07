package com.libraryspringboot.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity(name = "books")
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id

    String name

    int price

    int status

    int isUse


}
