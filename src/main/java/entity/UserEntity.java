package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity(name = "pub")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private boolean isAdult;

    @Column(nullable = false)
    private double pocket;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;

}
