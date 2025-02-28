package controller;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> allUsers() {
        return userService.allUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

}
