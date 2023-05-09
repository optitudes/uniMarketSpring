package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart registerShoppingCart(ShoppingCart s) throws Exception;

    ShoppingCart updateShoppingCart(ShoppingCart u) throws Exception;

    void deleteShoppingCart(int id) throws Exception;
}
