package repository;

import java.util.List;

public interface CrudOperations<T,K> {
    List<T> findAll();

    T findOne(K id);

    T save(T entity);

    T update(T entity);

    void delete(K id);
}
