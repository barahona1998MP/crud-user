package com.techalchemy.crud_user.repository;

import com.techalchemy.crud_user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
