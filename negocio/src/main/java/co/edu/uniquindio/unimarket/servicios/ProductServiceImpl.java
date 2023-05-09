package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Product;
import co.edu.uniquindio.unimarket.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product registerProduct(Product p) throws Exception {
        return productRepo.save(p);
    }

    @Override
    public Product updateProduct(Product p) throws Exception {
        return productRepo.save(p);
    }

    @Override
    public void deleteProduct(int id) throws Exception {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findByNameOrPrice(String pattern) throws Exception {

        return productRepo.finfByPattern(pattern);
    }
}
