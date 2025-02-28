package dto.mapper;

import dto.OrderDTO;
import entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity toEntity(OrderDTO source);
    OrderDTO toDTO(OrderEntity source);

}
