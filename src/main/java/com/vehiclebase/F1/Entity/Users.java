package com.vehiclebase.F1.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @Column(name = "id_user")
    private int id_user;

    @Column(name = "nick")
    private String nick;

    @Column(name = "password")
    private String password;

    @Column(name = "mail")
    private String mail;


}
