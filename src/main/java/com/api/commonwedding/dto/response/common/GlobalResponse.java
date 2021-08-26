package com.api.commonwedding.dto.response.common;

import lombok.Data;

@Data
public class GlobalResponse<T> {
    private String status;
    private String info;
    private T data;
}
