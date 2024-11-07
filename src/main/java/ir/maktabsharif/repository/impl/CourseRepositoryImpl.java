package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl implements CourseRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc_postgres");
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Course course) {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            Course course = em.find(Course.class,id);
            if (course!= null){
                em.remove(course);
            }else {
                System.out.println("not course");
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    @Override
    public Optional<List<Student>> readAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Course> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class,id);
        return Optional.ofNullable(course);
    }

    @Override
    public Optional<Course> update(Course course) {
            Optional<Course> course1 = findById(course.getId());
            if (course1.isPresent()){
                em.getTransaction().begin();
                em.merge(course);
                em.getTransaction().commit();
                em.close();
                return Optional.of(course);
            }else {
                return Optional.empty();
            }

    }
}
