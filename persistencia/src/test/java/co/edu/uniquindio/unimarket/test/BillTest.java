package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.Bill;
import co.edu.uniquindio.unimarket.repo.BillRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BillTest {


    @Autowired
    private BillRepo billRepo;

    @Test
    public void create(){
        Bill bill = new Bill(1,"101010",20000.0,null,null);
        Bill billSaved = billRepo.save(bill);
        Assertions.assertEquals("101010", billSaved.getBillCode());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void updateTest(){
        Optional<Bill> bill = billRepo.findById(1);
        if(bill.isPresent()){
            bill.get().setTotal(900000.0);
            billRepo.save(bill.get());
            Optional<Bill> billUpdated = billRepo.findById(1);
            if(billUpdated.isPresent()){
                Assertions.assertEquals(900000.0, billUpdated.get().getTotal());

            }else{
                Assertions.fail("No se encontró la categoria despues de actualizar");
            }
        }else{
            Assertions.fail("No se encontró la categoria");
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void remove(){

        Optional<Bill> bill = billRepo.findById(1);
        if(bill.isPresent()){
            billRepo.delete(bill.get());
            Assertions.assertFalse(billRepo.findById(1).isPresent());
        }else{
            Assertions.fail("No se encontró la factura");
        }
    }


}