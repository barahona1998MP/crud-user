package com.techalchemy.crud_user.service.implementation;

import com.techalchemy.crud_user.dto.UserDTO;
import com.techalchemy.crud_user.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {
    @Override
    public List<UserDTO> findAll() {
        return List.of();
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return "";
    }
}
