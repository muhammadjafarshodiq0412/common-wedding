package com.api.commonwedding.controller;

import com.api.commonwedding.dto.request.RoleTabRequest;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.api.commonwedding.services.impl.RoleTabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/role-tab")
public class RoleTabController {

    @Autowired
    private RoleTabServiceImpl service;

    @GetMapping("/")
    public GlobalResponse getData(){
        return service.getData();
    }
    @PostMapping("/add")
    public GlobalResponse add(@RequestBody RoleTabRequest request){
        return service.add(request);
    }

}
