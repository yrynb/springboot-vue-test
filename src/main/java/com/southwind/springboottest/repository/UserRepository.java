package com.southwind.springboottest.repository;

import com.southwind.springboottest.entity.USERKS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<USERKS,Integer> {
    USERKS findOneByKNAME(String name);
    USERKS findOneByKPASSWORD(String name);
}
