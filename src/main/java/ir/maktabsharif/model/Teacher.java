package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher extends BaseModel {
    @Column(name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column(name = "national_code" , unique = true)
    private String nationalCode;
    @Temporal(TemporalType.DATE)
    private Date dob;

    @OneToOne
        @JoinColumn(name = "fk_course")
   private Course course;
    @ManyToMany
    @JoinTable(
            name = "j_teacher_student",
            joinColumns = {@JoinColumn(name = "fk_teacher")},
            inverseJoinColumns = {@JoinColumn(name = "fk_student")}
    )
    private List<Student> students = new ArrayList<>();

}
