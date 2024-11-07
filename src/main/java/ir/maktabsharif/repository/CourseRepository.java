package ir.maktabsharif.repository;

import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends BaseRepository<Course> {
    @Override
    void create(Course entity);

    @Override
    void delete(Long id);

    @Override
    Optional<List<Student>> readAll();

    @Override
    Optional<Course> findById(Long id);

    @Override
    Optional<Course> update(Course entity);
}
