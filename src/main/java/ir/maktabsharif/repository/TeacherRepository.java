package ir.maktabsharif.repository;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends BaseRepository<Teacher> {
    @Override
    void create(Teacher entity);

    @Override
    void delete(Long id);

    @Override
    Optional<List<Student>> readAll();

    @Override
    Optional<Teacher> findById(Long id);

    @Override
    Optional<Teacher> update(Teacher entity);
}
