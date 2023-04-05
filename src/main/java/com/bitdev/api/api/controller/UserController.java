package com.bitdev.api.api.controller;

import com.bitdev.api.api.dto.user.*;
import com.bitdev.api.api.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(UserController.USERS_ENDPOINT)
public class UserController {
    public static final String USERS_ENDPOINT = "/users";
    UserService userService;

    //get user
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public GetUserDto get(@PathVariable Long id) {
        return userService.get(id);
    }

    //create user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserCreatedDto post(@RequestBody @Valid CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }

    //update user status
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}/status")
    public UserStatusUpdatedDto put(@PathVariable("id") Long id, @RequestBody @Valid UpdateUserStatusDto updateUserStatusDto) {
        return userService.updateStatus(id, updateUserStatusDto);
    }
}
