package com.example.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@IdClass(User.Key.class)
@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity<User.Key> {

    @JsonIgnore
    @Override
    public Key getId() {
        return new User.Key(name, address);
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Key implements Serializable {
        String name;
        String address;
    }

    @Id
    @Getter
    @Column(name = "NAME")
    private String name;

    @Id
    @Getter
    @Column(name = "ADDRESS")
    private String address;

    @Getter
    @Column(name = "DESC")
    private String description;

}
