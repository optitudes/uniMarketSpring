package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.LevelAccess;

public interface LevelAccessService {
    LevelAccess registerLevelAccess(LevelAccess l) throws Exception;

    LevelAccess updateLevelAccess(LevelAccess l) throws Exception;

    void deleteLevelAccess(int id) throws Exception;
}
