package service;

import dto.UserDTO;
import dto.mapper.UserMapper;
import entity.UserEntity;
import entity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        UserEntity entity = userMapper.toEntity(userDTO);
        entity = userRepository.save(entity);
        return userMapper.toDTO(entity);
    }

    @Override
    public List<UserDTO> allUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(long id) {
        return userMapper.toDTO(fetchUserById(id));
    }

    private UserEntity fetchUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User is not found with id: " + id));
    }
}
