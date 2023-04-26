package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.Product;
import co.edu.uniquindio.unimarket.repo.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    public void create(){

        Product product = new Product(1,"url","pan","un pan muy rico",20.0,true,new Date(),true,null,null,null,null);
        Product productSaved = productRepo.save(product);
        Assertions.assertEquals("pan", productSaved.getName());
        System.out.println(productSaved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void updateTest(){
        Optional<Product> product = productRepo.findById(1);
        if(product.isPresent()){
            product.get().setName("mortadela");
            productRepo.save(product.get());
            Optional<Product> productUpdated = productRepo.findById(1);
            if(productUpdated.isPresent()){
                Assertions.assertEquals("mortadela", productUpdated.get().getName());

            }else{
                Assertions.fail("No se encontró el producto despues de actualizar");
            }
        }else{
            Assertions.fail("No se encontró el producto");
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void remove(){

        Optional<Product> product = productRepo.findById(3);
        if(product.isPresent()){
            productRepo.delete(product.get());
            Assertions.assertFalse(productRepo.findById(3).isPresent());
        }else{
            Assertions.fail("No se encontró el producto");
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void findByName(){

        Optional<Product> product = productRepo.findByName("pan");
        if(product.isPresent()){
            Assertions.assertEquals("un pan muy rico",product.get().getDescription());
        }else{
            Assertions.fail("No se encontró el producto");
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void findByIsActive(){

        List<Product> productList = productRepo.findByIsActive(true);
        Boolean isFour = productList.size() == 4;
        Assertions.assertTrue(isFour);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void findByPatternProductTest(){
        List<Product> prducts = productRepo.finfByPattern("pa");
        Assertions.assertEquals(2, prducts.size());
    }
}