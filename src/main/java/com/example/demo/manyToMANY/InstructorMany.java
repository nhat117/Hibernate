package com.example.demo.manyToMANY;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class InstructorMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    //Declare mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetailMany instructorDetail;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy = "instructor",
            cascade ={CascadeType.PERSIST, CascadeType.MERGE,
                                        CascadeType.DETACH, CascadeType.REFRESH})
    private List <Course> courses;

    public InstructorMany() {
    }

    public InstructorMany(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetailMany getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetailMany instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }

    //Convenience method
    public void add(Course tmpCourse) {
        if(courses == null) {
            courses = new ArrayList<Course>();
        }
        courses.add(tmpCourse);
        tmpCourse.setInstructor(this);
    }
}
