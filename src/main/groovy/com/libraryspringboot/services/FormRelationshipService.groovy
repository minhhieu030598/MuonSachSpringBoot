package com.libraryspringboot.services

import com.libraryspringboot.models.form_show.FormRelationship

interface FormRelationshipService {

    List<FormRelationship> getAll(String sortField, boolean sortType, int pageNumber)
}
