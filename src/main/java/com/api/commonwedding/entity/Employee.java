package com.api.commonwedding.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
public class Employee extends BaseModel{
    private String nik;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private GlobalParam gender;
    @OneToOne(cascade = CascadeType.ALL)
    private GlobalParam religion;
    private String address;
}
