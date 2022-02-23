package com.example.demo.manyToMANY;

import javax.persistence.*;

//Anootate
@Entity
@Table(name="instructor_detail")
public class InstructorDetailMany {

    //Define field
    //Anootate the field with db and column names
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="youtube_channel")
    private String youtubeChannel;
    @Column(name="hobby")
    private String hobby;
    //Add mew field for instructor
    //Add @OneToOne annotatuon
    @OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private InstructorMany instructor;

    //Create constructor
    public InstructorDetailMany() {
    }

    public InstructorDetailMany(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    //Generate getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public InstructorMany getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorMany instructor) {
        this.instructor = instructor;
    }

    //To string

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
