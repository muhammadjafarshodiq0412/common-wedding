package com.api.commonwedding.services;

import com.api.commonwedding.dto.request.RoleTabRequest;
import com.api.commonwedding.dto.response.common.GlobalResponse;

public interface RoleTabService {
    GlobalResponse add(RoleTabRequest request);
    GlobalResponse getData();
}
