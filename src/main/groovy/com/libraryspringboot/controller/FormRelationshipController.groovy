package com.libraryspringboot.controller

import com.libraryspringboot.models.form_request.FormRequestPivot
import com.libraryspringboot.models.form_request.Pagination
import com.libraryspringboot.models.form_show.FormRelationship
import com.libraryspringboot.repositorys.FormRelationshipRepository
import com.libraryspringboot.services.FormRelationshipService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pivot")
class FormRelationshipController {

    @Autowired
    FormRelationshipRepository repository

    @Autowired
    FormRelationshipService service

    @GetMapping
    List<FormRelationship> getAll(@RequestParam(value = "book-name", defaultValue = "") String bookName,
                                  @RequestParam(value = "user-name", defaultValue = "") String userName,
                                  @RequestParam(value = "date-from", defaultValue = "") String dateFrom,
                                  @RequestParam(value = "date-to", defaultValue = "") String dateTo,
                                  @RequestParam(value = "sort-field", defaultValue = "book_name") String sortField,
                                  @RequestParam(value = "page-number", defaultValue = "0") int pageNumber,
                                  @RequestParam(value = "sort-type", defaultValue = "") boolean sortType) {
        return service.getAll(new FormRequestPivot(bookName, userName, dateFrom, dateTo),
                new Pagination(pageNumber, sortField, sortType)
        )
    }

}
