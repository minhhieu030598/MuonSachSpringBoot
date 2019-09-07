package com.libraryspringboot.services.impl

import com.libraryspringboot.models.form_show.FormRelationship
import com.libraryspringboot.repositorys.FormRelationshipRepository
import com.libraryspringboot.services.FormRelationshipService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class FormRelationshipServiceImpl implements FormRelationshipService {

    @Autowired
    FormRelationshipRepository repository

    @Override
    List<FormRelationship> getAll(String sortField, boolean sortType, int pageNumber) {
        Sort sort = sortType ? Sort.by(sortField.toString().trim()).ascending() : Sort.by(sortField.toString().trim()).descending()
        Pageable pageable = PageRequest.of(pageNumber, 4, sort)
        return repository.getAll(pageable)
    }
}
