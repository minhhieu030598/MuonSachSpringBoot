package com.libraryspringboot.controller

import com.libraryspringboot.models.form_show.FormRelationship
import com.libraryspringboot.repositorys.FormRelationshipRepository
import com.libraryspringboot.services.FormRelationshipService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pivot")
class FormRelationshipController {

    @Autowired
    FormRelationshipRepository repository

//    @GetMapping
//    List<FormRelationship> getAll(){
//        Sort sort = Sort.by("book_name").descending()
//        Pageable pageable = PageRequest.of(0, 4, sort)
//        return repository.getAll(pageable)
//    }

    @Autowired
    FormRelationshipService service

    @GetMapping
    List<FormRelationship> getAll(@RequestParam("sort-field") String sortField,
                                  @RequestParam("page-number") int pageNumber,
                                  @RequestParam("sort-type") boolean sortType) {
        return service.getAll(sortField, sortType, pageNumber)
    }
}
