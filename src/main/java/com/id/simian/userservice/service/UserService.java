package com.id.simian.userservice.service;

import com.id.simian.userservice.dto.request.UserRegistrationDto;
import com.id.simian.userservice.entity.Role;
import com.id.simian.userservice.entity.User;
import com.id.simian.userservice.exception.ResourceNotFoundException;
import com.id.simian.userservice.repository.RoleRepository;
import com.id.simian.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserRegistrationDto saveUser(UserRegistrationDto userRegistrationDto){

        log.info("Request Save User -> {} ", userRegistrationDto);

        Optional<Role> role =
                Optional.ofNullable(roleRepository.findById(userRegistrationDto.getRole())
                        .orElseThrow(() -> new ResourceNotFoundException
                                ("Cannot Find Role ID " + userRegistrationDto.getRole())));
        if(role.isPresent()) {
            User user = new User(
                    userRegistrationDto.getFirstName(),
                    userRegistrationDto.getLastName(),
                    userRegistrationDto.getEmail(),
                    userRegistrationDto.getPassword()
            );
            user.getRoles().add(role.get());
            userRepository.save(user);
        }
        return userRegistrationDto;
    }

    public UserRegistrationDto updateUser(Long id, UserRegistrationDto userRegistrationDto){

        log.info("Request Update ID User -> {}, {} ",id, userRegistrationDto);

        Optional<Role> role =
                Optional.ofNullable(roleRepository.findById(userRegistrationDto.getRole())
                        .orElseThrow(() -> new ResourceNotFoundException
                                ("Cannot Find Role ID " + userRegistrationDto.getRole())));
        if(role.isPresent()) {
            Optional<User> findUser =
                    Optional.ofNullable(userRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException
                                    ("Cannot Find User ID " + id)));
            if(findUser.isPresent()) {
                User user = new User(
                        id,
                        userRegistrationDto.getFirstName(),
                        userRegistrationDto.getLastName(),
                        userRegistrationDto.getEmail(),
                        userRegistrationDto.getPassword()
                );
                user.getRoles().add(role.get());
                userRepository.save(user);
            }
        }
        return userRegistrationDto;
    }

    public Long deleteUser(Long id){

        log.info("Request Delete ID User -> {}",id);
            Optional<User> user =
                    Optional.ofNullable(userRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException
                                    ("Cannot Find User ID " + id)));
        user.ifPresent(value -> userRepository.delete(value));
        return id;
    }

}
