package com.api.commonwedding.services;

import com.api.commonwedding.dto.request.EmployeeRequestDto;
import com.api.commonwedding.dto.response.common.GlobalResponse;

public interface EmployeeService {
    GlobalResponse add(EmployeeRequestDto request);
    GlobalResponse getData();
}
