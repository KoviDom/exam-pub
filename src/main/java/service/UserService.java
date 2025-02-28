package service;

import dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> allUsers();

    UserDTO findById(long id);

}
