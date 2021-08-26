package com.api.commonwedding.controller.base;

import com.api.commonwedding.dto.response.common.GlobalResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseRestController<T> {

    @GetMapping("/all")
    T getAll();

    @PostMapping("/add")
    T save(@RequestBody T request);
}
