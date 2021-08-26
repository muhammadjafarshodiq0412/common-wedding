package com.api.commonwedding.dto.request;

import lombok.Data;

@Data
public class UserTabRequest {
    private String email;
    private String password;
    private Long roleId;
}
