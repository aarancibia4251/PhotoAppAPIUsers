package com.appsdeveloperblog.photoappa.api.users.data.repository;

import com.appsdeveloperblog.photoappa.api.users.data.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
