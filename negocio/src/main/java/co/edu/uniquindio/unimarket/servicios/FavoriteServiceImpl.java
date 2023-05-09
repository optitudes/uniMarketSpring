package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Favorite;
import co.edu.uniquindio.unimarket.repo.FavoriteRepo;

public class FavoriteServiceImpl implements FavoriteService{
    private final FavoriteRepo favoriteRepo;

    public FavoriteServiceImpl(FavoriteRepo favoriteRepo) {
        this.favoriteRepo = favoriteRepo;
    }

    @Override
    public Favorite registerFavorite(Favorite f) throws Exception {
        return favoriteRepo.save(f);
    }

    @Override
    public Favorite updateFavorite(Favorite f) throws Exception {
        return favoriteRepo.save(f);
    }

    @Override
    public void deleteFavorite(int id) throws Exception {
        favoriteRepo.deleteById(id);
    }
}
