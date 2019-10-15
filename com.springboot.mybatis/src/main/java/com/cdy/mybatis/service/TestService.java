package com.cdy.mybatis.service;

import com.cdy.mybatis.dto.Test;

import java.util.Map;

/**
* test
* @author chendeyou
* @date 2019/08/12
*/
public interface TestService {

    /**
    * 新增
    */
    public int insert(Test test);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(Test test);

    /**
    * 根據主鍵 id 查詢
    */
    public Test selectByPrimaryKey(int id);

    /**
    * 分页查询
    */
    public Map<String,Object> pageList(int offset, int pagesize);

}
