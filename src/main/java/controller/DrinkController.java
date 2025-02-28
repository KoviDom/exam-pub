package controller;

import dto.DrinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DrinkService;

import java.util.List;

@RestController
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping("/drink-menu")
    public List<DrinkDTO> drinkMenu() {
        return drinkService.drinkMenu();
    }

}
