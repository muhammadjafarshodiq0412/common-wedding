package com.api.commonwedding.services.impl;

import com.api.commonwedding.constant.GlobalConstant;
import com.api.commonwedding.dto.request.RoleTabRequest;
import com.api.commonwedding.dto.response.RoleTabDto;
import com.api.commonwedding.dto.response.common.GlobalResponse;
import com.api.commonwedding.entity.RoleTab;
import com.api.commonwedding.repository.RoleTabRepository;
import com.api.commonwedding.services.RoleTabService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoleTabServiceImpl implements RoleTabService {
    @Autowired
    private RoleTabRepository repository;

    @Override
    public GlobalResponse add(RoleTabRequest request) {
        log.info("Create RoleTabEntity : " + request);
        RoleTab model = new RoleTab();
        BeanUtils.copyProperties(request, model, "id");
        repository.save(model);

        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setInfo(GlobalConstant.INFO_SUCCESS);
        globalResponse.setStatus(GlobalConstant.STATUS_SUCCESS);
        globalResponse.setData(model);
        log.info("Create RoleTabEntity Finished...");
        return globalResponse;
    }

    @Override
    public GlobalResponse getData() {
        log.info("Get All Data RoleTabEntity Started... ");
        GlobalResponse globalResponse = new GlobalResponse();
        List<RoleTab> models = repository.findAll();
        List<RoleTabDto> roleTabDtos = new ArrayList<>();
        log.info("Data :: " + models);
        for (RoleTab roleTab : models) {
            RoleTabDto roleTabDto = new RoleTabDto();
            BeanUtils.copyProperties(roleTab, roleTabDto);
            roleTabDtos.add(roleTabDto);
        }
        globalResponse.setData(roleTabDtos);
        globalResponse.setInfo(GlobalConstant.INFO_SUCCESS);
        globalResponse.setStatus(GlobalConstant.STATUS_SUCCESS);

        log.info("Get RoleTabEntity Get All Data Finished...");
        return globalResponse;
    }
}
