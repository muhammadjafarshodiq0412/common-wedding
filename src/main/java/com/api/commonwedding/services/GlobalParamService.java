package com.api.commonwedding.services;

import com.api.commonwedding.dto.request.GlobalParamRequestDto;
import com.api.commonwedding.dto.response.common.GlobalResponse;

public interface GlobalParamService {
    GlobalResponse add(GlobalParamRequestDto request);
    GlobalResponse getData();
}
