package com.libraryspringboot.services

import com.libraryspringboot.models.database.Relationship
import com.libraryspringboot.models.system_response.MessageResponse
import org.springframework.http.ResponseEntity

interface RelationshipService {
    ResponseEntity<MessageResponse> create(List<Relationship> relationships)
}
