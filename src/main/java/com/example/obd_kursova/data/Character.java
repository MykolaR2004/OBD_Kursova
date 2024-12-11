package com.example.obd_kursova.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "Trait", nullable = false)
    private String trait;

    @ManyToMany(mappedBy = "traits")
    private List<Client> clients;
}