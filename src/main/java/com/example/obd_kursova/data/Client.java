package com.example.obd_kursova.data;

import com.example.obd_kursova.model.Characters;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "surname", nullable = false)
    private String surname;

    @Lob
    @Column(name = "aboutyourself", nullable = false)
    private String aboutYourself;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "photo")
    private String photo;

    @ManyToMany
    @JoinTable(name = "hobbylist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private List<Hobby> hobbies;

    @ManyToMany
    @JoinTable(name = "requirements_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "requirement_id"))
    private List<Requirement> requirements;

    @ManyToMany
    @JoinTable(name = "characters_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private List<Character> traits;
}
