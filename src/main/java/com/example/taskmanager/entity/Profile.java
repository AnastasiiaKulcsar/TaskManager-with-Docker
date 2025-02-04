package com.example.taskmanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "task_counts")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer done_count;
    private Integer not_done_count;


    public Long getId() {
        return id;
    }

    public Integer getDone_count() {
        return done_count;
    }



    public Integer getNot_done_count() {
        return not_done_count;
    }


}
