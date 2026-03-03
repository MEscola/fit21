package com.project.fit21.user.entity;

import java.sql.Date;

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
@Table(name = "profile")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Profile {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    private String user_id;

    private String goal;

    private String level;

    private Date birth_date;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private User coach;

}
