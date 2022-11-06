package com.Spring.SpringJPA.studentcourse_v2.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student2")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_seq2",
            initialValue = 1,
            allocationSize = 1
    )
    private Long id;

    @Column(name = "student_text")
    private String text;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<CourseRegistration> students;
}
