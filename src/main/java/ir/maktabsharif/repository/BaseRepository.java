package ir.maktabsharif.repository;

import ir.maktabsharif.model.Student;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    void create(T entity);
    void delete(Long id);
    Optional<List<Student>> readAll();
    Optional<T> findById(Long id);
    Optional<T> update(T entity);
}
