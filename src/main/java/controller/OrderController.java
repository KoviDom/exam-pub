package controller;

import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/buy")
    public OrderDTO buyDrink(@PathVariable long userId,@PathVariable long drinkId) {
        return orderService.buyDrink(userId, drinkId);
    }

}
