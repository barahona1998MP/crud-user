package com.techalchemy.crud_user.dao.interfaces;

import com.techalchemy.crud_user.dto.UserDTO;
import com.techalchemy.crud_user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    void save(UserEntity userEntity);

    void update(UserEntity userEntity);

    void delete(UserEntity userEntity);
}
