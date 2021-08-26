package com.api.commonwedding.controller;

import com.api.commonwedding.dto.request.EmployeeRequestDto;
import com.api.commonwedding.dto.request.GlobalParamRequestDto;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.api.commonwedding.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/")
    public GlobalResponse getData(){
        return service.getData();
    }
    @PostMapping("/add")
    public GlobalResponse add(@RequestBody EmployeeRequestDto request){
        return service.add(request);
    }
}
