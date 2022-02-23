package com.example.demo.EagerVSLazy;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {
    //Define our fields

    //Define constructors

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    //define

    //Annotate field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private InstructorMany instructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InstructorMany getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorMany instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
