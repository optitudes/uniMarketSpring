package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.Comment;
import co.edu.uniquindio.unimarket.entidades.Coupon;
import co.edu.uniquindio.unimarket.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface CouponRepo  extends JpaRepository<Coupon, Integer> {

}