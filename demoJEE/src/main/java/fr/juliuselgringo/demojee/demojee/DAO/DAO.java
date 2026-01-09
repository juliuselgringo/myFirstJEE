package fr.juliuselgringo.demojee.demojee.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO <T>{

    protected DAO() throws SQLException {
    }

    /**
     * Creation et persistance d'un objet T
     * @param entity
     * @return
     */
    public abstract T create(T entity) throws SQLException;

    /**
     * Mise à jour et persistance d'un objet T
     * @param entity
     * @return 1 for success 0 for error
     */
    public abstract boolean update(T entity) throws SQLException;

    /**
     * Suppression et persistance d'un objet T
     * @param pId
     * @return 1 for success 0 for error
     */
    public abstract boolean deleteById(Integer pId) throws SQLException;

    /**
     * Recherche par id
     * @param pId
     * @return l'objet T ciblé
     */
    public abstract T findById(Integer pId) throws SQLException;

    /**
     * recherche global
     * @return liste de tous les objets T
     */
    public abstract List<T> findAll(Connection conn) throws SQLException;

}
