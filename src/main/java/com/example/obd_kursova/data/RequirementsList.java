package com.example.obd_kursova.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "requirements_list")
public class RequirementsList {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_ID", nullable = false)
    private Client userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Requirement_ID", nullable = false)
    private Requirement requirementId;

}