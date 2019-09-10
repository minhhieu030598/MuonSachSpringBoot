package com.libraryspringboot.controller

import com.libraryspringboot.models.database.Relationship
import com.libraryspringboot.models.system_response.MessageResponse
import com.libraryspringboot.services.RelationshipService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/relationship")
class RelationshipController {

    @Autowired
    RelationshipService service

    @PostMapping
    void create(@RequestBody List<Relationship> relationships){
        service.create(relationships)
    }




}
