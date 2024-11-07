package ir.maktabsharif;
import ir.maktabsharif.model.Address;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Gender;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.impl.CourseRepositoryImpl;
import ir.maktabsharif.repository.impl.ExamRepositoryImpl;
import ir.maktabsharif.repository.impl.StudentRepositoryImpl;
import ir.maktabsharif.util.Count;
import ir.maktabsharif.util.Util;
import lombok.var;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
   static Scanner sc = new Scanner(System.in);
    public static void createStudent(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc_postgres");
//        EntityManager em = emf.createEntityManager();

        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        System.out.println("Enter FirstName:");
        String firstName = sc.next();
        System.out.println("Enter LastName:");
        String lastName = sc.next();
        System.out.println("Enter NationalCode:");
        String nationalCode = sc.next();
       Student student = Student.builder()
                .firstName(firstName).lastName(lastName).nationalCode(nationalCode)
                .build();
        studentRepository.create(student);

    }
    public static void findByID(Long id){
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
       Optional<Student> studentOptional= studentRepository.findById(id);
       if (studentOptional.isPresent()){
            Student student = studentOptional.get();
           System.out.println(student);
       }
    }

    public static void main(String[] args) {

//        Optional<Student> student = studentRepository.findById(1L);
//        student.ifPresent(s -> System.out.println("Found student: " + s.getFirstName()));
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc_postgres");
//    EntityManager em = emf.createEntityManager();
    StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
//    studentRepository.delete(2L);
//        Student student = new Student();
//        System.out.println("id");
//        Long id = sc.nextLong();
//        System.out.println("firstName");
//        String firstName = sc.next();
//        System.out.println("lastName");
//        String lastName = sc.next();
//        System.out.println("nationalCode");
//        String nationalCode = sc.next();
//        student.setId(id);
//        student.setFirstName(firstName);
//        student.setLastName(lastName);
//        student.setNationalCode(nationalCode);
//        studentRepository.update(student);
//            CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();
//        ExamRepositoryImpl examRepository = new ExamRepositoryImpl();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc_postgres");
//        EntityManager em = emf.createEntityManager();
//        Address address = Address.builder()
//                .country("iran").city("tehran").zipCode("11111111111")
//                .build();
//        Student student = Student.builder()
//                .firstName("hasan").lastName("abasii").gender(Gender.MALE).address(address)
//                .build();
//
//                em.getTransaction().begin();
//                em.persist(student);
//                em.getTransaction().commit();
//
//
//    Util.createStudent();
        Count count = new Count();
        count.start();
    }

}

