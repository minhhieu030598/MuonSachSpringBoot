package com.libraryspringboot.models.form_show

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jdk.nashorn.internal.ir.annotations.Immutable

import javax.persistence.Entity
import javax.persistence.Id
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Immutable
@Entity
class FormRelationship {

    @Id
    int id

    int idBook

    int idUser

    String bookName

    String userName

    LocalDateTime dateFrom

    LocalDateTime dateTo

    LocalDateTime createAt

    LocalDateTime modifyAt

}
