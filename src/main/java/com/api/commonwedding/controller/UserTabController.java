package com.api.commonwedding.controller;

import com.api.commonwedding.dto.request.UserTabRequest;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.api.commonwedding.services.UserTabService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user-tab")
public class UserTabController {
    @Autowired
    private UserTabService service;

    @PostMapping("/add")
    public GlobalResponse add(@RequestBody UserTabRequest request){
        return service.add(request);
    }

    @GetMapping("/")
    public GlobalResponse getAll() throws JsonProcessingException {
        return service.getData();
    }

}
