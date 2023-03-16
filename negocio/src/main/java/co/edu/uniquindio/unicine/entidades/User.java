package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    private Long id;

    @Column(name="email", length=50,unique=true,nullable = false)
    private String email;

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

    @OneToOne(mappedBy="user")
    private Favorite favorite;

    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;

    @OneToOne(mappedBy = "user")
    private LevelAccess levelAccess;

    @OneToMany(mappedBy = "user")
    private List<Coupon> couponList;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;
}
