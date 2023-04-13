package com.bibvip.crud.controller;

import com.bibvip.crud.exception.ResourceNotFoundException;
import com.bibvip.crud.model.User;
import com.bibvip.crud.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/pagination/list")
    public ResponseEntity<Page<User>> userPagination(@RequestParam Integer page, @RequestParam Integer size) {
        return new ResponseEntity<>(userService.userPagination(page,size), HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    @SneakyThrows
    public ResponseEntity<Optional<User>> findUserById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/findByFirstName")
    public ResponseEntity<List<User>>  findByFirstName(@RequestBody User user) {
        return new ResponseEntity<>(userService.findByFirstName(user), HttpStatus.OK);
    }

}
