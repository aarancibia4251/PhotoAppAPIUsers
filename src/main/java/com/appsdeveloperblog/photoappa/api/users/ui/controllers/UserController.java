package com.appsdeveloperblog.photoappa.api.users.ui.controllers;

import com.appsdeveloperblog.photoappa.api.users.service.UserService;
import com.appsdeveloperblog.photoappa.api.users.shared.UserDto;
import com.appsdeveloperblog.photoappa.api.users.ui.model.request.CreateUserRequestModel;
import com.appsdeveloperblog.photoappa.api.users.ui.model.response.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private Environment env;

    @Autowired
    UserService userService;

    @GetMapping("status/check")
    public String status() {
        return "Working" + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(userDetails, UserDto.class);

        UserDto createdUserDto = userService.createUser(userDto);
        CreateUserResponseModel returnValue = mapper.map(createdUserDto, CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
