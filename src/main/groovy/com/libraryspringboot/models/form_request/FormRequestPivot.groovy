package com.libraryspringboot.models.form_request

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
class FormRequestPivot {

    String bookName

    String userName

    LocalDateTime dateTo

    LocalDateTime dateFrom


}
