package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.ExamRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class ExamRepositoryImpl implements ExamRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc_postgres");
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Exam exam) {
        try {
            em.getTransaction().begin();
            em.persist(exam);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            Exam exam = em.find(Exam.class,id);
            if (exam!= null){
                em.remove(exam);
            }else {
                System.out.println("not exam");
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
    public Optional<Exam> findById(Long id) {
        Exam exam = em.find(Exam.class,id);
        return Optional.ofNullable(exam);
    }

    @Override
    public Optional<Exam> update(Exam exam) {
        Optional<Exam> examOptional = findById(exam.getId());
        if (examOptional.isPresent()){
            em.getTransaction().begin();
            em.merge(exam);
            em.getTransaction().commit();
            return Optional.ofNullable(exam);
        }else {
            return Optional.empty();
        }
    }
}
