package co.edu.uniquindio.unimarket.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="billCode", length=45,nullable = false)
    private String billCode;

    @Column(name="total",nullable = false)
    private Double total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        return Objects.equals(id, bill.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "bill")
    @ToString.Exclude
    List<BillDetail> billDetailList;
}