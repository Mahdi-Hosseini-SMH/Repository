package ir.maktabsharif.repository;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository<S extends BaseModel> extends BaseRepository<Student> {
    @Override
    void create(Student entity);

    @Override
    void delete(Long id);

    @Override
    Optional<List<Student>> readAll();

    @Override
    Optional<Student> findById(Long id);

    @Override
    Optional<Student> update(Student entity);
}
