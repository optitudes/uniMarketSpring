package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Coupon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="coupon_value",nullable = false)
    private Double couponValue;

    @Column(name="security_code", length=20,unique=true,nullable = false)
    private String securityCode;

    @Column(name="description", length=100)
    private String description;

    @Column(name="is_active",nullable = false)
    private Double isActive;

    @Column(name="limit_date",nullable = false)
    private Date limitDate;

    @ManyToOne
    private User user;

}
