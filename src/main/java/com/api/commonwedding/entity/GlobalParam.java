package com.api.commonwedding.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class GlobalParam extends BaseModel{
    private String param_condition;
    private int param_value;
    private int param_value2;
    private String param_desc;
    private String param_desc2;
    private String info;
}
