package com.api.commonwedding.services.impl;

import com.api.commonwedding.constant.GlobalConstant;
import com.api.commonwedding.dto.request.EmployeeRequestDto;
import com.api.commonwedding.dto.response.EmployeeDto;
import com.api.commonwedding.dto.response.GlobalParamDto;
import com.api.commonwedding.dto.response.RoleTabDto;
import com.api.commonwedding.dto.response.UserTabDto;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.api.commonwedding.entity.Employee;
import com.api.commonwedding.entity.GlobalParam;
import com.api.commonwedding.entity.RoleTab;
import com.api.commonwedding.entity.UserTab;
import com.api.commonwedding.repository.EmployeeRepository;
import com.api.commonwedding.repository.GlobalParamRepository;
import com.api.commonwedding.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    GlobalParamRepository globalParamRepository;

    @Override
    public GlobalResponse add(EmployeeRequestDto request) {
        log.info("Create EmployeeEntity : " + request);
        GlobalParam gender = globalParamRepository.findById(request.getGender()).orElse(null);
        GlobalParam religion = globalParamRepository.findById(request.getReligion()).orElse(null);

        Employee model = new Employee();
        BeanUtils.copyProperties(request, model, "id");
        model.setGender(gender);
        model.setReligion(religion);
        employeeRepository.save(model);

        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setInfo(GlobalConstant.INFO_SUCCESS);
        globalResponse.setStatus(GlobalConstant.STATUS_SUCCESS);
        globalResponse.setData(model);
        log.info("Create EmployeeEntity Finished...");
        return globalResponse;
    }

    @Override
    public GlobalResponse getData() {
        log.info("Get All Data UserTabEntity Started... ");

        GlobalResponse globalResponse = new GlobalResponse();
        List<Employee> models = employeeRepository.findAll();
        List<EmployeeDto> dtos = new ArrayList<>();
        if (!models.isEmpty()) {
            for (Employee model : models) {
                EmployeeDto dto = new EmployeeDto();
                BeanUtils.copyProperties(model, dto);
                dto.setGender(new ModelMapper().map(model.getGender(),new GlobalParamDto().getClass()));
                dto.setReligion(new ModelMapper().map(model.getReligion(),new GlobalParamDto().getClass()));
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
        log.info("Get UserTabEntity Get All Data Finished...");
        return globalResponse;
    }
}
