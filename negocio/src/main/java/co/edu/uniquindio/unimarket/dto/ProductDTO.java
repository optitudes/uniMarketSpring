package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
@Data
@AllArgsConstructor
public class ProductDTO {
    private Integer id;

    private String image;

    private String name;

    private String description;

    private Double price;

    private Boolean isAvailable;

    private Integer stacks;

    private Date limitDate;

    private Boolean isActive;

}
