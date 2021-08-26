package com.api.commonwedding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseDto {
    private Long id;
    private String uuid;
    private boolean enabled;
    @JsonProperty("DateCreated")
    private Date DateCreated;
    @JsonProperty("DateModified")
    private Date DateModified;
}
