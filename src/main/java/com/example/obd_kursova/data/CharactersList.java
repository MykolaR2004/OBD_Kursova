package com.example.obd_kursova.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "characters_list")
public class CharactersList {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID")
    private Client userID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Character_ID")
    private Character characterId;

}
