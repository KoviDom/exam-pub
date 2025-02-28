package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private DrinkEntity drinkEntity;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private double price;

}
