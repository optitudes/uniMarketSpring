package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="image", length=100)
    private String image;

    @Column(name="name", length=45)
    private String name;

    @Column(name="description", length=100)
    private String description;

    @Column(name="price",nullable = false)
    private Double price;

    @Column(name="is_available",nullable = false)
    private Boolean isAvailable;

    private Date limitDate;

    @Column(name="is_active",nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "product")
    private List<Comment> commentList;

    @ManyToMany(mappedBy = "productList")
    private List<Category> categoryList;

    @ManyToMany(mappedBy = "productList")
    private List<Favorite> favoriteList;

    @ManyToMany(mappedBy = "productList")
    private List<ShoppingCart> shoppingCartList;

}
