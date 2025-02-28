package service;

import dto.DrinkDTO;
import dto.mapper.DrinkMapper;
import entity.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService{

    private final DrinkMapper drinkMapper;
    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkServiceImpl(DrinkMapper drinkMapper, DrinkRepository drinkRepository) {
        this.drinkMapper = drinkMapper;
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<DrinkDTO> drinkMenu() {
        return drinkRepository.findAll()
                .stream()
                .map(drinkMapper::toDTO)
                .collect(Collectors.toList());
    }
}
