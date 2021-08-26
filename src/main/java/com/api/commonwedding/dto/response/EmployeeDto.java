package com.api.commonwedding.dto.response;

import com.api.commonwedding.dto.BaseDto;
import com.api.commonwedding.entity.GlobalParam;
import lombok.Data;


@Data
public class EmployeeDto extends BaseDto {
    private String nik;
    private String name;
    private GlobalParamDto gender;
    private GlobalParamDto religion;
    private String address;
}
