package com.libraryspringboot.services.impl

import com.libraryspringboot.models.database.User
import com.libraryspringboot.models.system_response.MessageResponse
import com.libraryspringboot.repositorys.UserRepository
import com.libraryspringboot.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository

    @Override
    ResponseEntity<MessageResponse> create(User user) {
        if (user) {
            repository.save(user)
            return new ResponseEntity<>(MessageResponse.data.get("inserted"), HttpStatus.OK)
        }
        return new ResponseEntity<>(MessageResponse.data.get("error_server"), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @Override
    ResponseEntity<MessageResponse> modify(User user) {
        if (user) {
            repository.save(user)
            return new ResponseEntity<>(MessageResponse.data.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<>(MessageResponse.data.get("error_server"), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @Override
    ResponseEntity<MessageResponse> delete(int id) {
        User user = repository.findById(id).orElse(null)
        if (user) {
            user.setStatus(0)
            repository.save(user)
            return new ResponseEntity<>(MessageResponse.data.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<>(MessageResponse.data.get("error_server"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
