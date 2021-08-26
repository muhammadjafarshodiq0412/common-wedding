package com.api.commonwedding.services;

import com.api.commonwedding.dto.request.UserTabRequest;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface UserTabService {

    GlobalResponse add(UserTabRequest request);

    GlobalResponse getData() throws JsonProcessingException;
}
