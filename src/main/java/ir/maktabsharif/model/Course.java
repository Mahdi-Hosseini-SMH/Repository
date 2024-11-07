package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Course extends BaseModel {
    private Integer unit;
    private String title;
    @OneToMany
    List<Exam> exams = new ArrayList<>();
    @ManyToMany(mappedBy = "courses")
    List<Student> students = new ArrayList<>();
    @OneToOne
    private Teacher teacher;
}
