package com.libraryspringboot.services

import com.libraryspringboot.models.form_request.FormRequestPivot
import com.libraryspringboot.models.form_request.Pagination
import com.libraryspringboot.models.form_show.FormRelationship

interface FormRelationshipService {

    List<FormRelationship> getAll(FormRequestPivot formRequestPivot, Pagination pagination)
}
