package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CouponRepo  extends JpaRepository<Coupon, Integer> {

}