package service;

import dto.OrderDTO;
import dto.mapper.OrderMapper;
import entity.DrinkEntity;
import entity.OrderEntity;
import entity.UserEntity;
import entity.repository.DrinkRepository;
import entity.repository.OrderRepository;
import entity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final DrinkRepository drinkRepository;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository, UserRepository userRepository, DrinkRepository drinkRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.drinkRepository = drinkRepository;
    }

    @Override
    public OrderDTO buyDrink(long userId, long drinkId) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        DrinkEntity drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new NotFoundException("Drink is not found"));

        if (user.isAdult() && user.getPocket() > drink.getPrice()) {
            System.out.println("You can buy a drink!!!");
        } else {
            System.out.println("Not enough money or you are not the Adult...");
        }

        OrderEntity order = new OrderEntity();

        order.setUserEntity(user);
        order.setProductName(drink.getProductName());

        order = orderRepository.save(order);

        //zaplatit
        user.setPocket(user.getPocket() - drink.getPrice());

        user = userRepository.save(user);

        return orderMapper.toDTO(order);
    }

}
