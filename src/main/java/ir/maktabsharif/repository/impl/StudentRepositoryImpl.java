package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository<Student> {
    private EntityManagerFactory emf =Persistence.createEntityManagerFactory("jdbc_postgres");
    @Override
    public void create(Student student) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(student);
    em.getTransaction().commit();

    }

    @Override
    public void delete(Long id) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Student student = em.find(Student.class,id);
    if (student != null){
        em.remove(student);
    }
    em.getTransaction().commit();
    }

    @Override
    public Optional<List<Student>> readAll() {
            EntityManager em = emf.createEntityManager();
            try {
                List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
                em.close();
                return students.isEmpty() ? Optional.empty() : Optional.of(students);

            } catch (Exception e) {
                em.close();
                e.printStackTrace();
                return Optional.empty();
            }


    }

    @Override
    public Optional<Student> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class,id);
    return Optional.ofNullable(student);
    }

    @Override
    public Optional<Student> update(Student student) {
        EntityManager em = emf.createEntityManager();
        Optional<Student> existingStudent = findById(student.getId());
        if (existingStudent.isPresent()) {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
            em.close();
            return Optional.of(student);
        } else {
            em.close();
            return Optional.empty();
        }
    }
    public long countStudents() {
        EntityManager em = emf.createEntityManager();
        long count = 0;
        try {
            count = em.createQuery("SELECT COUNT(s) FROM Student s", Long.class).getSingleResult();
        } finally {
            em.close();
        }
        return count;
    }
}
