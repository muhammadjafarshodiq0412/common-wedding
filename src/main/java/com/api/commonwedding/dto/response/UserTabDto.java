package com.api.commonwedding.dto.response;

import com.api.commonwedding.dto.BaseDto;
import lombok.Data;

import java.util.Date;

@Data
public class UserTabDto extends BaseDto {
    private String email;
    private String password;
    private RoleTabDto role;
}
