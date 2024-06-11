package com.techalchemy.crud_user.service.implementation;

import com.techalchemy.crud_user.dao.interfaces.UserDAO;
import com.techalchemy.crud_user.dto.UserDTO;
import com.techalchemy.crud_user.entity.UserEntity;
import com.techalchemy.crud_user.service.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    final UserDAO userDAO;

    private UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<UserDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.userDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<UserEntity> userEntity = this.userDAO.findById(id);
        if(userEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            UserEntity currentUserEntity = userEntity.get();
            return modelMapper.map(currentUserEntity, UserDTO.class);
        } else {
            return new UserDTO();
        }
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            this.userDAO.save(userEntity);
            return userDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error saving the user");
        }
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long id) {
        Optional<UserEntity> userEntity = this.userDAO.findById(id);
        if(userEntity.isPresent()){
            UserEntity currentUserEntity = userEntity.get();
            currentUserEntity.setFirstName(userDTO.getFirstName());
            currentUserEntity.setLastName(userDTO.getLastName());
            currentUserEntity.setEmail(userDTO.getEmail());
            currentUserEntity.setAge(userDTO.getAge());
            this.userDAO.update(currentUserEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentUserEntity, UserDTO.class);
        } else {
            throw new IllegalArgumentException("The user does not exist");
        }
    }

    @Override
    public String delete(Long id) {
        Optional<UserEntity> userEntity = this.userDAO.findById(id);
        if(userEntity.isPresent()) {
            UserEntity currentUserEntity = userEntity.get();
            this.userDAO.delete(currentUserEntity);
            return "User with ID " +id +" deleted successfully";
        }
        return "The user with ID:"+id +" does not exist";
    }
}
