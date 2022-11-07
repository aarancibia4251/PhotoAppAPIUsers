package com.appsdeveloperblog.photoappa.api.users.service;

import com.appsdeveloperblog.photoappa.api.users.shared.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetails);
}
