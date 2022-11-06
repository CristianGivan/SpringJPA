package com.Spring.SpringJPA.studentcourse_v1.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq",
            sequenceName = "student_seq",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "student_id")
    private Long id;

    @Column(name = "stunde_text")
    private String text;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
            )
    private List<Course> likeCourses;

    public Student() {
    }
}
