package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Favorite;

public interface FavoriteService {
    Favorite registerFavorite(Favorite f) throws Exception;

    Favorite updateFavorite(Favorite f) throws Exception;

    void deleteFavorite(int id) throws Exception;
}
