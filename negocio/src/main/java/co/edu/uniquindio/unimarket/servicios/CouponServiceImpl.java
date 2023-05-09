package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Coupon;
import co.edu.uniquindio.unimarket.repo.CouponRepo;

public class CouponServiceImpl implements CouponService{

    private final CouponRepo couponRepo;

    public CouponServiceImpl(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }

    @Override
    public Coupon registerCoupon(Coupon c) throws Exception {
        return couponRepo.save(c);
    }

    @Override
    public Coupon updateCoupon(Coupon c) throws Exception {
        return couponRepo.save(c);
    }

    @Override
    public void deleteCoupon(int id) throws Exception {
        couponRepo.deleteById(id);
    }
}
