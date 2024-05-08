package com.example.obd_kursova.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_1_ID", nullable = false)
    private Client user1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_2_ID", nullable = false)
    private Client user2;

    @Column(name = "`Creation date`", nullable = false)
    private Instant creationDate;

    @Lob
    @Column(name = "Message", nullable = false)
    private String message;

}