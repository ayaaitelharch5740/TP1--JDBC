/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ORIGINAL SHOP
 */
import java.util.List;

public interface IDao<T> {
    T       findById(int id) throws Exception;
    List<T> findAll()        throws Exception;
    int     insert(T obj)    throws Exception;
    boolean update(T obj)    throws Exception;
    boolean delete(int id)   throws Exception;
}