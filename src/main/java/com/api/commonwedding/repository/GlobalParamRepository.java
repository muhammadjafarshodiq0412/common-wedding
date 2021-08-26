package com.api.commonwedding.repository;

import com.api.commonwedding.entity.GlobalParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalParamRepository extends JpaRepository<GlobalParam,Long> {
}
