package com.Spring.SpringJPA.studentcourse_v2.Entities;

import javax.persistence.*;

@Entity
@Table(name = "course_registrations2")
public class CourseRegistration {

    @Id
    @Column(name = "course_student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_student_seq")
    @SequenceGenerator(
            name = "course_student_seq",
            sequenceName = "course_student_seq2",
            initialValue = 1,
            allocationSize = 1
    )
    private Long id;

    @Column(name = "registration_date_text")
    private String registrationDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;




}
