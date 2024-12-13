package com.example.obd_kursova.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hobbylist")
public class Hobbylist {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID")
    private Client userID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hobby_ID")
    private Hobby hobbyId;


}