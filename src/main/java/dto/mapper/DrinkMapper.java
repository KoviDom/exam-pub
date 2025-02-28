package dto.mapper;

import dto.DrinkDTO;
import entity.DrinkEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DrinkMapper {

    DrinkEntity toEntity(DrinkDTO source);

    DrinkDTO toDTO(DrinkEntity source);

}
