package com.forcelate.Controller;
import com.forcelate.DTO.ExceptionResponse;
import com.forcelate.DTO.UserDTO;
import com.forcelate.Entity.Enum.Color;
import com.forcelate.ServiceAndIMPL.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser (@Valid  @RequestBody UserDTO user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String message = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            String field = bindingResult.getFieldErrors().get(0).getField();
            return new ResponseEntity<>(new ExceptionResponse("validation " + field + " failed", message), HttpStatus.BAD_REQUEST);
        }
        userService.SaveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public  ResponseEntity<?> gteUserById(@PathVariable("id") Long id){
        UserDTO userDTO = userService.findUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("age/{age}")
    public ResponseEntity<?> getAllUsersWhereAgeMore (@PathVariable("age") int age){
        List<UserDTO> users = userService.getAllUsersWhereAgeMore(age);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("color")
    public ResponseEntity<?> getAllUsersByColor (@RequestParam Color color){
        List<UserDTO> users = userService.getAllUsersWithArticlesByColor(color);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("art/{count}")
    public  ResponseEntity<?> getUniqueNames(@PathVariable("count") Long count){
        List<String> userDTO = userService.getUniqueNameByArticleCount(count);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
