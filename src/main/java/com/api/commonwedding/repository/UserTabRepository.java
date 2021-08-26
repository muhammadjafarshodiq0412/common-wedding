package com.api.commonwedding.repository;

import com.api.commonwedding.entity.UserTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTabRepository extends JpaRepository<UserTab,Long> {
}
