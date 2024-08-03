package com.jp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.entity.UserEmployee;

public interface UserEmployeeRepo extends JpaRepository<UserEmployee, Integer> {

}
