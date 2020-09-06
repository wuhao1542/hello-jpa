package com.example.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity<String> {

    @Id
    @Getter
    @Column(name = "NAME")
    private String id;

    @Getter
    @Column(name = "DESC")
    private String description;

}
