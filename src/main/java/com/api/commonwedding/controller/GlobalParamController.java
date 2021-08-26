package com.api.commonwedding.controller;

import com.api.commonwedding.dto.request.GlobalParamRequestDto;
import com.api.commonwedding.dto.request.RoleTabRequest;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.api.commonwedding.services.GlobalParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/global-param")
public class GlobalParamController {
    @Autowired
    GlobalParamService service;

    @GetMapping("/")
    public GlobalResponse getData(){
        return service.getData();
    }
    @PostMapping("/add")
    public GlobalResponse add(@RequestBody GlobalParamRequestDto request){
        return service.add(request);
    }
}
