package com.Spring.SpringJPA.studentcourse_v1.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq",
            sequenceName = "course_seq",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "course_id")
    private Long id;

    @Column(name = "text_course")
    private String text;
    @ManyToMany(mappedBy = "likeCourses")
    private List<Student> like;

    public Course() {
    }
}
