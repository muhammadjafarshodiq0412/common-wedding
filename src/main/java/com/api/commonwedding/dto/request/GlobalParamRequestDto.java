package com.api.commonwedding.dto.request;

import lombok.Data;

@Data
public class GlobalParamRequestDto {
    private String param_condition;
    private int param_value;
    private int param_value2;
    private String param_desc;
    private String param_desc2;
    private String info;
}
