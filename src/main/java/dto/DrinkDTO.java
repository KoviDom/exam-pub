package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkDTO {

    @JsonProperty("_id")
    private Long id;

    private String productName;

    private double price;

    private boolean isForAdult;

}
