package com.api.commonwedding.dto.request;

import lombok.Data;

@Data
public class EmployeeRequestDto {
    private String nik;
    private String name;
    private Long gender;
    private Long religion;
    private String address;
}
