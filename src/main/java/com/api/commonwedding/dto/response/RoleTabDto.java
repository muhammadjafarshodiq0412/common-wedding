package com.api.commonwedding.dto.response;

import com.api.commonwedding.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
//@JsonPropertyOrder({
//        "id",
//        "roleName"
//        })
public class RoleTabDto extends BaseDto{
//    private Long id;
//    @JsonProperty("roleName")
    private String roleName;
}
