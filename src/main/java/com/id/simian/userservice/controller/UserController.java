package com.id.simian.userservice.controller;

import com.id.simian.userservice.dto.request.UserRegistrationDto;
import com.id.simian.userservice.service.UserService;
import com.id.simian.userservice.utils.ErrorFieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration-user")
    public ResponseEntity<Object> registration(@RequestBody @Valid UserRegistrationDto userRegistrationDTO,
                                           BindingResult bindingResult)  {

        if (bindingResult.hasErrors()){
            return ErrorFieldUtils.customErrors(bindingResult.getAllErrors());
        }

        return ResponseEntity.ok( userService.saveUser(userRegistrationDTO));

    }

    @PutMapping(value = "/registration-user/{id}")
    public ResponseEntity<Object> registrationUserUpdate(
                                               @PathVariable("id") Long id,
                                               @RequestBody
                                               @Valid UserRegistrationDto userRegistrationDTO,
                                               BindingResult bindingResult)  {

        if (bindingResult.hasErrors()){
            return ErrorFieldUtils.customErrors(bindingResult.getAllErrors());
        }

        return ResponseEntity.ok( userService.updateUser(id, userRegistrationDTO));

    }

    @DeleteMapping(value = "/registration-user/{id}")
    public ResponseEntity<Object> registrationUserDelete(
            @PathVariable("id") Long id)  {

        return ResponseEntity.ok( "Successfully Deleted User ID " + userService.deleteUser(id));

    }

}
