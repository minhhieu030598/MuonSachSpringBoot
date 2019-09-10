package com.libraryspringboot.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id

    String name

    int status

    User() {
    }

    User(String name, int status) {
        this.name = name
        this.status = status
    }
}
