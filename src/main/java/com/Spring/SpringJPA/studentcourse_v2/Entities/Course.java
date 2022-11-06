package com.Spring.SpringJPA.studentcourse_v2.Entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course2")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(
            name = "course_seq",
            sequenceName = "course_seq2",
            initialValue = 1,
            allocationSize = 1
    )
    private Long id;

    @Column(name = "course_text")
    private String text;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseRegistration> courses;
}
