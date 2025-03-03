package dto.mapper;

import dto.UserDTO;
import entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDTO source);

    UserDTO toDTO(UserEntity source);

}
