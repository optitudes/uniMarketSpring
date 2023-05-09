package co.edu.uniquindio.unimarket.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    private Integer id;

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

    @Column(name = "stacks",nullable = false)
    private Integer stacks;

    private Date limitDate;

    @Column(name="is_active",nullable = false)
    private Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    @JsonIgnore

    private List<Comment> commentList;

    @ManyToMany(mappedBy = "productList")
    @JsonIgnore
    private List<Category> categoryList;

    @ManyToMany(mappedBy = "productList")
    @JsonIgnore

    private List<Favorite> favoriteList;

    @ManyToMany(mappedBy = "productList")
    @JsonIgnore

    private List<ShoppingCart> shoppingCartList;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    @JsonIgnore
    List<BillDetail> billDetailList;

}
