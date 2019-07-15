package com.forcelate.ServiceAndIMPL;


import com.forcelate.DTO.UserDTO;
import com.forcelate.Entity.Enum.Color;

import java.util.List;

public interface UserService {

    UserDTO SaveUser(UserDTO user);

    UserDTO findUserById(Long id);

    List<UserDTO> getAllUsers();

    List<UserDTO> getAllUsersWhereAgeMore(int age);

    List<UserDTO> getAllUsersWithArticlesByColor (Color color);

    List<String> getUniqueNameByArticleCount(Long count);
}
