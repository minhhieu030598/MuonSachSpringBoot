package com.libraryspringboot.services.impl

import com.libraryspringboot.models.database.Relationship
import com.libraryspringboot.models.system_response.MessageResponse
import com.libraryspringboot.repositorys.RelationshipRepository
import com.libraryspringboot.services.RelationshipService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class RelationshipSerImpl implements RelationshipService {

    @Autowired
    RelationshipRepository repository

    @Override
    ResponseEntity<MessageResponse> create(List<Relationship> relationships) {
        relationships.each {relationship ->
            repository.save(relationship)
        }
        return new ResponseEntity<>(MessageResponse.data.get("inserted"), HttpStatus.OK)

    }
}
