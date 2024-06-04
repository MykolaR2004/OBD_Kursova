package com.example.obd_kursova.model;

import java.util.Date;

public interface ExistingChat {
    Integer getId();
    Integer getUser_1_ID();
    String getClient1NameSurname();
    Integer getUser_2_ID();
    String getClient2NameSurname();
    Date getCreation_date();
    String getMessage();
}
