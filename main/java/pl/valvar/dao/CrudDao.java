package pl.valvar.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    void find(Integer id);
    void save(T model);
    void update(T model);
    void delete(Integer id);
}
