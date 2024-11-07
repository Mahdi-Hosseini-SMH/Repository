package ir.maktabsharif.util;

import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.impl.CourseRepositoryImpl;
import ir.maktabsharif.repository.impl.ExamRepositoryImpl;
import ir.maktabsharif.repository.impl.StudentRepositoryImpl;
import ir.maktabsharif.repository.impl.TeacherRepositoryImpl;

import java.util.Optional;
import java.util.Scanner;

public class Util {
    static Scanner sc = new Scanner(System.in);
    static StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    static CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();
    static ExamRepositoryImpl examRepository = new ExamRepositoryImpl();
    static TeacherRepositoryImpl teacherRepository = new TeacherRepositoryImpl();
    public static void createStudent(){
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
    public static void studentFindByID(Long id){
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        Optional<Student> studentOptional= studentRepository.findById(id);
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            System.out.println(student);
        }else {
            System.out.println("not id");
        }
    }
    public static void studentDeleteById(Long id){
        studentRepository.delete(id);
        System.out.println("Done");
    }
    public static void studentUpdateById(Long id){
        Student student = new Student();
        System.out.println("id");
        System.out.println("firstName");
        String firstName = sc.next();
        System.out.println("lastName");
        String lastName = sc.next();
        System.out.println("nationalCode");
        String nationalCode = sc.next();
        student.setId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setNationalCode(nationalCode);
        studentRepository.update(student);
        System.out.println("Done");
    }
    public static void courseCreate(){
        System.out.println("Enter unit:");
        Integer unit = sc.nextInt();
        System.out.println("Enter Title");
        String title = sc.next();
        Course course = Course.builder()
                .unit(unit).title(title)
                .build();
        CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();
        courseRepository.create(course);
    }
    public static void courseFindBYId(){
        Optional<Course> course = courseRepository.findById(6L);
        if (course.isPresent()){
            Course course1 = course.get();
            System.out.println(course1);
        }else {
            System.out.println("not fund");
        }
    }
    public static void courseUpdateById(Long id){
        Course course = new Course();
        System.out.println("Enter id:");
        System.out.println("Enter Unit");
        Integer unit = sc.nextInt();
        System.out.println("Enter Title:");
        String title = sc.nextLine();
        course.setId(id);
        course.setUnit(unit);
        course.setTitle(title);
        courseRepository.update(course);
        System.out.println("Done");
    }
    public static void createExam(){
        Exam exam = Exam.builder()
                .title("java1").grade(20.0)
                .build();
        examRepository.create(exam);
    }
    public static void examFindById(Long id){
        Optional<Exam> exam = examRepository.findById(id);
        if (exam.isPresent()){
            Exam exam1 = exam.get();
            System.out.println(exam1);
        }else {
            System.out.println("not exam");
        }
    }
    public static void updateExamById(Long id){
        Exam exam = new Exam();
        exam.setId(8L);
        exam.setTitle("C");
        exam.setGrade(100.0);
        examRepository.update(exam);
    }
    public static void deleteExamById(Long id){
        examRepository.delete(id);
    }
    public static void createTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("teacher1").lastName("teacher11").lastName("22211222").
                build();
        teacherRepository.create(teacher);

    }
    public static void deleteTeacher(Long id){
        teacherRepository.delete(id);
    }
    public static void findByIdTeacher(Long id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()){
            Teacher teacher1 = teacher.get();
            System.out.println(teacher1);
        }else {
            System.out.println("not teacher");
        }
    }
    public static void updateTeacher(Long id){
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setFirstName("ali");
        teacher.setLastName("hosseini");
        teacher.setNationalCode("2221121212");
        teacherRepository.update(teacher);
    }

}
