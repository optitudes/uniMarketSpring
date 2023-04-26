package co.edu.uniquindio.unimarket.repo;

import co.edu.uniquindio.unimarket.entidades.BillDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillDetailRepo extends JpaRepository<BillDetail, Integer> {

    Optional<BillDetail> findByPrice(String price);

    Page<BillDetail> findAll(Pageable pageable);

    Optional<BillDetail> findById(Integer id);

    Optional<BillDetail> findByAmount(Integer amount);

}