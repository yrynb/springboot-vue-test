package com.southwind.springboottest.repository;

import com.southwind.springboottest.entity.Empsalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpSalaryRepository extends JpaRepository<Empsalary,Integer> {
}
