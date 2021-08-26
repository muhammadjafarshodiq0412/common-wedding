package com.api.commonwedding.services.impl;

import com.api.commonwedding.constant.GlobalConstant;
import com.api.commonwedding.dto.request.EmployeeRequestDto;
import com.api.commonwedding.dto.request.GlobalParamRequestDto;
import com.api.commonwedding.dto.response.EmployeeDto;
import com.api.commonwedding.dto.response.GlobalParamDto;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.api.commonwedding.entity.Employee;
import com.api.commonwedding.entity.GlobalParam;
import com.api.commonwedding.repository.GlobalParamRepository;
import com.api.commonwedding.services.GlobalParamService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GlobalParamServiceImpl implements GlobalParamService {

    @Autowired
    GlobalParamRepository globalParamRepository;

    @Override
    public GlobalResponse add(GlobalParamRequestDto request) {
        log.info("Create GlobalParamEntity : " + request);

        GlobalParam model = new GlobalParam();
        BeanUtils.copyProperties(request, model, "id");
        globalParamRepository.save(model);

        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setInfo(GlobalConstant.INFO_SUCCESS);
        globalResponse.setStatus(GlobalConstant.STATUS_SUCCESS);
        globalResponse.setData(model);
        log.info("Create GlobalParamEntity Finished...");
        return globalResponse;
    }

    @Override
    public GlobalResponse getData() {
        log.info("Get All Data GlobalParamEntity Started... ");

        GlobalResponse globalResponse = new GlobalResponse();
        List<GlobalParam> models = globalParamRepository.findAll();
        List<GlobalParamDto> dtos = new ArrayList<>();
        if (!models.isEmpty()) {
            for (GlobalParam model : models) {
                GlobalParamDto dto = new GlobalParamDto();
                BeanUtils.copyProperties(model, dto);
                dtos.add(dto);
            }
            globalResponse.setData(dtos);
            globalResponse.setInfo(GlobalConstant.INFO_SUCCESS);
            globalResponse.setStatus(GlobalConstant.STATUS_SUCCESS);
        } else {
            globalResponse.setInfo(GlobalConstant.INFO_SUCCESS);
            globalResponse.setStatus(GlobalConstant.STATUS_SUCCESS);
            globalResponse.setData(null);
        }
        log.info("Data :: " + models);
        log.info("Get GlobalParamEntity Get All Data Finished...");
        return globalResponse;
    }
}
