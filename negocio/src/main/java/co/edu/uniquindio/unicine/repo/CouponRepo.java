package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Comment;
import co.edu.uniquindio.unicine.entidades.Coupon;
import co.edu.uniquindio.unicine.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface CouponRepo  extends JpaRepository<Coupon, Integer> {

}