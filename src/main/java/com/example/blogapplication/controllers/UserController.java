package com.example.blogapplication.controllers;

import com.example.blogapplication.payloads.ApiResponse;
import com.example.blogapplication.payloads.UserDto;
import com.example.blogapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST-Create User
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {/* we use @Valid annotation to enable the validation isn controller */
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //PUT-Update User
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer id) {
        UserDto updatedUser = this.userService.updateUser(userDto, id);
        return ResponseEntity.ok(updatedUser);

    }

    //DELETE-Delete User
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Only the ADMIN can have access to take actions
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {

        this.userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User deleted sucessfully", true), HttpStatus.OK);
    }

    //GET ALL-Read User
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok(this.userService.getAllUser());
    }
    //GET USER BY ID

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

}
