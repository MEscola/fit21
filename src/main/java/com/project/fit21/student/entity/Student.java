package com.project.fit21.student.entity;

import com.project.fit21.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Student {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String name;

    private String goal;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private User coach;

}
