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
public class Exam extends BaseModel {
    private String title;
    private Double grade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToMany
    @JoinTable(name ="j_exam_student",
    joinColumns = {@JoinColumn(name = "fk_exam")},
            inverseJoinColumns = {@JoinColumn(name = "fk_student")}
    )
    List<Student> students = new ArrayList<>();
    @ManyToOne
    private Course course;

}
