package com.api.commonwedding.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_tab")
public class UserTab extends BaseModel{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, unique = true, updatable = false)
//    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private RoleTab role;

}
