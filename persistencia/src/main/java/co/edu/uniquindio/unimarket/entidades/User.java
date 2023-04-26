package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="email", length=50,unique=true,nullable = false)
    private String email;

    @Column(name="name", length=45,unique=true,nullable = false)
    private String name;
    @Column(name="password",length=45,nullable = false)
    private String password;

    @Column(name="dni",length=20,unique=true,nullable = false)
    private String dni;

    @Column(name="phone_number", length=15)
    private String phoneNumber;

    @Column(name="address", length=45,nullable = false)
    private String address;

    @Column(name="is_active",nullable = false)
    private Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @OneToOne(mappedBy="user")
    private Favorite favorite;

    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @NotNull
    private LevelAccess levelAccess;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Coupon> couponList;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Comment> commentList;
}
