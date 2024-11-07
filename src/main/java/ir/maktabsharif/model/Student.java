package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "student")
public class Student extends BaseModel {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_code", unique = true)
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Embedded
    Address address;
    @ManyToMany
            @JoinTable(
                    name = "j_student_courses",
                    joinColumns = {@JoinColumn(name = "fk_student")},
                    inverseJoinColumns = { @JoinColumn(name = "fk_course")}
            )
    List<Course> courses = new ArrayList<>();
    @ManyToMany(mappedBy = "students")
    List<Exam> exams = new ArrayList<>();
    @ManyToMany(mappedBy = "students")
    List<Teacher> teachers = new ArrayList<>();
}
