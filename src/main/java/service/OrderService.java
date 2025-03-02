package service;

import dto.OrderDTO;

public interface OrderService {

    OrderDTO buyDrink(long userId, long productId);

}
