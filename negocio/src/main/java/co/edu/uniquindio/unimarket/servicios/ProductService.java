package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.entidades.Product;

import java.util.List;

public interface ProductService {
    Product registerProduct(Product p) throws Exception;

    Product updateProduct(Product p) throws Exception;

    void deleteProduct(int id) throws Exception;
    List<ProductDTO> findByNameOrPrice(String pattern) throws Exception;

}
