package com.api.commonwedding.repository;

import com.api.commonwedding.entity.RoleTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleTabRepository extends JpaRepository<RoleTab,Long> {
}
