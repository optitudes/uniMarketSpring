package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
@Data
@AllArgsConstructor
public class BillDTO {
    private Integer id;

    private String billCode;

    private Double total;

}
