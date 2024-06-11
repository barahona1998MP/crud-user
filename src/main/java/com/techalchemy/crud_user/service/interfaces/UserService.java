package com.techalchemy.crud_user.service.interfaces;

import com.techalchemy.crud_user.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO, Long id);

    String delete(Long id);
}
