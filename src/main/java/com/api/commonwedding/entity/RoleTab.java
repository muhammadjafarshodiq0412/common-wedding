package com.api.commonwedding.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role_tab")
public class RoleTab extends BaseModel{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id",nullable = false,updatable = false)
//    private Long id;

    @Column(name = "role_name")
    private String roleName;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roleId")
//    private UserTab userTab;
}
