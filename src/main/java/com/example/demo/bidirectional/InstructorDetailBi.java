package com.example.demo.bidirectional;

import com.example.demo.hb.Instructor;

import javax.persistence.*;

//Anootate
@Entity
@Table(name="instructor_detail")
public class InstructorDetailBi {

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
    private InstructorBi instructor;

    //Create constructor
    public InstructorDetailBi() {
    }

    public InstructorDetailBi(String youtubeChannel, String hobby) {
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

    public InstructorBi getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorBi instructor) {
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
