package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class LevelAccess implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="access_code",unique=true,nullable = false)
    private Integer accessCode;

    @Column(name="description", length=100,nullable = false)
    private String description;

    @OneToOne
    private User user;
}
