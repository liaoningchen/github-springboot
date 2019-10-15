package com.cdy.jpa.repository;

import com.cdy.jpa.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
//继承JpaRepository 来完成对数据库的增删改查操作
public interface TestRepository extends JpaRepository<Test, Integer> {
}
