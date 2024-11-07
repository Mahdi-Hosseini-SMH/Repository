package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.Exam;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;


public class TeacherRepositoryImpl implements TeacherRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc_postgres");
    EntityManager em = emf.createEntityManager();

    @Override
    public void create(Teacher teacher) {
        try {
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            Teacher teacher = em.find(Teacher.class, id);
            if (teacher != null) {
                em.remove(teacher);
            } else {
                System.out.println("not teacher");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Optional<List<Student>> readAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        Teacher teacher = em.find(Teacher.class, id);
        return Optional.ofNullable(teacher);
    }

    @Override
    public Optional<Teacher> update(Teacher teacher) {
        Optional<Teacher> teacherOptional = findById(teacher.getId());
        if (teacherOptional.isPresent()) {
            em.getTransaction().begin();
            em.merge(teacherOptional);
            em.getTransaction().commit();
            return Optional.of(teacher);
        } else {
            return Optional.empty();
        }
    }
}
