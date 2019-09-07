package com.libraryspringboot.controller

import com.libraryspringboot.models.database.User
import com.libraryspringboot.models.system_response.MessageResponse
import com.libraryspringboot.repositorys.UserRepository
import com.libraryspringboot.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    UserService service

    @PostMapping
    ResponseEntity<MessageResponse> create(@RequestBody User user){
        return service.create(user)
    }

    @PutMapping
    ResponseEntity<MessageResponse> modify(@RequestBody User user){
        return service.modify(user)
    }

    @PatchMapping("/{id}")
    ResponseEntity<MessageResponse> delete(@PathVariable int id){
        return service.delete(id)
    }



}
