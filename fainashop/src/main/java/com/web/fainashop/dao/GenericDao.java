package com.web.fainashop.dao;

import java.util.List;

/**
 * Created by Home on 27.09.2014.
 */
public interface GenericDao<T> {

    public boolean save(T item);
    public boolean update(T item);
    public T getById(int objectId);
    public List<T> getAll();
    public boolean delete(T item);

}
