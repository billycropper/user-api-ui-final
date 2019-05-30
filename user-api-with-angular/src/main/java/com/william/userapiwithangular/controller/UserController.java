package com.william.userapiwithangular.controller;

import com.william.userapiwithangular.domain.User;
import com.william.userapiwithangular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@CrossOrigin (origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //@CrossOrigin (origins = "http://localhost:4200")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> createUserRecord(@Valid @RequestBody User user){
        userService.createUser(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        responseHeaders.setLocation(newUserUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //@CrossOrigin (origins = "http://localhost:4200")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllUsers(){
        Iterable<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        //"/allusers"
    }

    //@CrossOrigin (origins = "http://localhost:4200")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //@CrossOrigin (origins = "http://localhost:4200")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserRecord(@RequestBody User user, @PathVariable Long id){
        if(userService.existsById(id)){
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return createUserRecord(user);
        }
    }

    //@CrossOrigin (origins = "http://localhost:4200")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserRecord(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
