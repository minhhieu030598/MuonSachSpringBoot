package com.libraryspringboot.services.impl

import com.libraryspringboot.models.form_request.FormRequestPivot
import com.libraryspringboot.models.form_request.Pagination
import com.libraryspringboot.models.form_show.FormRelationship
import com.libraryspringboot.repositorys.BookRepository
import com.libraryspringboot.repositorys.FormRelationshipRepository
import com.libraryspringboot.repositorys.UserRepository
import com.libraryspringboot.services.FormRelationshipService
import org.apache.tomcat.jni.Local
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import java.time.LocalDateTime

@Service
class FormRelationshipServiceImpl implements FormRelationshipService {

    @Autowired
    FormRelationshipRepository repository

    @Autowired
    BookRepository bookRepository

    @Autowired
    UserRepository userRepository

    @Override
    List<FormRelationship> getAll(FormRequestPivot request, Pagination pagination) {
        Sort sort = pagination.getSortType() ? Sort.by(pagination.getSortField().toString().trim()).ascending() : Sort.by(pagination.getSortField().toString().trim()).descending()

        Pageable pageable = PageRequest.of(pagination.getPageNumber(), 20, sort)
        List<FormRelationship> result = new ArrayList<>()

        if (!request) {
            result = repository.getLimit()
        }

        if (request.getUserName() == 'all' || request.getBookName() == 'all') {
//            result = repository.getAll(sort)
        }

        if (request.getUserName() && request.getUserName() != 'all') {
            result.clear()
            repository.findAllData().findAll { it -> it.getUserName() == request.getUserName().trim() }.each {
                formRelationship -> result.add(formRelationship)
            }
        }

        if (request.getBookName() && request.getBookName() != 'all') {
            result.clear()
            repository.findAllData().findAll { it -> it.getBookName() == request.getBookName().trim() }.each {
                formRelationship -> result.add(formRelationship)
            }
        }

        if (request.getDateFrom() && request.getDateTo()) {
            result.findAll {
                it ->
                    !(it.getCreateAt().isAfter(request.getDateFrom()) && it.getCreateAt().isBefore(request.getDateTo()))
                    result.remove(it)
            }
        }

        return result
    }

}
