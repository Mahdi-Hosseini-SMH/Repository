package ir.maktabsharif.repository;

import ir.maktabsharif.model.Exam;
import ir.maktabsharif.model.Student;

import java.util.List;
import java.util.Optional;

public interface ExamRepository extends BaseRepository<Exam> {
    @Override
    void create(Exam entity);

    @Override
    void delete(Long id);

    @Override
    Optional<List<Student>> readAll();

    @Override
    Optional<Exam> findById(Long id);

    @Override
    Optional<Exam> update(Exam entity);
}
