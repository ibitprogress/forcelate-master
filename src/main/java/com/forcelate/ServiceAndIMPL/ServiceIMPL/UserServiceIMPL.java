package com.forcelate.ServiceAndIMPL.ServiceIMPL;
import com.forcelate.DTO.UserDTO;
import com.forcelate.Entity.Enum.Color;
import com.forcelate.Entity.UserEntity;
import com.forcelate.Exception.NotFoundException;
import com.forcelate.ObjectMapperUtils;
import com.forcelate.Repository.UserRepository;
import com.forcelate.ServiceAndIMPL.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils objectMapperUtils;

    @Override
    public UserDTO SaveUser(UserDTO user) {
        if (user == null)
            throw new NotFoundException("enter user");
        else {
            UserEntity userEntity = objectMapperUtils.map(user, UserEntity.class);
            userRepository.save(userEntity);
            return user;
        }
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserEntity userById = userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("users with id "+id+" not found")
        );
        UserDTO userDTO = objectMapperUtils.map(userById, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntity = userRepository.findAll();
        if(userEntity.size()==0)
            throw new NotFoundException("users not found");
        else {
            List<UserDTO> userDTO = objectMapperUtils.mapAll(userEntity, UserDTO.class);
            return userDTO;
        }
    }

    @Override
    public List<UserDTO> getAllUsersWhereAgeMore(int age) {
        List<UserEntity> users = userRepository.findAllByAgeAfter(age);
        if (users.size()==0)
            throw new NotFoundException("users with age "+age+" and more not found");
        else {
            List<UserDTO> userDTO = objectMapperUtils.mapAll(users, UserDTO.class);
            return userDTO;
        }
    }

    @Override
    public List<UserDTO> getAllUsersWithArticlesByColor(Color color) {

        List<UserEntity> user = userRepository.findAllByArticlesColor(color);
        if(user.size()==0)
            throw new NotFoundException("users with color "+color+" not found");
        else {
            List<UserDTO> userDTO = objectMapperUtils.mapAll(user, UserDTO.class);
            return userDTO;
        }

    }

    @Override
    public List<String> getUniqueNameByArticleCount(Long count) {
        List<String> allByArticles = userRepository.getAllByArticles(count);
        if (allByArticles.size()==0)
            throw new NotFoundException("unique users names with article count "+count+" not found");
        else
            return allByArticles;
    }
}
