package com.api.commonwedding.services.impl;

import com.api.commonwedding.constant.GlobalConstant;
import com.api.commonwedding.dto.request.UserTabRequest;
import com.api.commonwedding.dto.response.RoleTabDto;
import com.api.commonwedding.dto.response.UserTabDto;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.api.commonwedding.entity.RoleTab;
import com.api.commonwedding.entity.UserTab;
import com.api.commonwedding.repository.RoleTabRepository;
import com.api.commonwedding.repository.UserTabRepository;
import com.api.commonwedding.services.UserTabService;
import com.api.commonwedding.utils.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserTabServiceImpl implements UserTabService {
    @Autowired
    private RoleTabRepository roleTabRepository;
    @Autowired
    private UserTabRepository repository;
    @Autowired
    private CommonUtil commonUtil;

    private ObjectMapper objectMapper;

    @Override
    public GlobalResponse add(UserTabRequest request) {
        log.info("Create UserTabEntity : " + request);
        RoleTab roleTab = roleTabRepository.findById(request.getRoleId()).orElse(null);

        UserTab model = new UserTab();
        BeanUtils.copyProperties(request, model, "id", "password");
        model.setPassword(commonUtil.hashPwdBcrypt(request.getPassword()));
        model.setRole(roleTab);
        repository.save(model);

        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setInfo(GlobalConstant.INFO_SUCCESS);
        globalResponse.setStatus(GlobalConstant.STATUS_SUCCESS);
        globalResponse.setData(model);
        log.info("Create UserTabEntity Finished...");
        return globalResponse;
    }

    @Override
    public GlobalResponse getData() {
        log.info("Get All Data UserTabEntity Started... ");

        GlobalResponse globalResponse = new GlobalResponse();
        List<UserTab> models = repository.findAll();
        List<UserTabDto> userTabDtos = new ArrayList<>();
        if (!models.isEmpty()) {
            for (UserTab model : models) {
                UserTabDto dto = new UserTabDto();
                BeanUtils.copyProperties(model, dto);
                dto.setRole(new ModelMapper().map(model.getRole(), new RoleTabDto().getClass()));
                userTabDtos.add(dto);
            }
            globalResponse.setData(userTabDtos);
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
