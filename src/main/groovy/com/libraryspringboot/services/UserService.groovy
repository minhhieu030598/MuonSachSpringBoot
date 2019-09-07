package com.libraryspringboot.services

import com.libraryspringboot.models.database.User
import com.libraryspringboot.models.system_response.MessageResponse
import org.springframework.http.ResponseEntity


interface UserService {

    ResponseEntity<MessageResponse> create(User user)

    ResponseEntity<MessageResponse> modify(User user)

    ResponseEntity<MessageResponse> delete(int id)


}
