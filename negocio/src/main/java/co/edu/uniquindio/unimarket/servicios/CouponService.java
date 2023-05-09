package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Coupon;

public interface CouponService {
    Coupon registerCoupon(Coupon c) throws Exception;

    Coupon updateCoupon(Coupon c) throws Exception;

    void deleteCoupon(int id) throws Exception;
}
