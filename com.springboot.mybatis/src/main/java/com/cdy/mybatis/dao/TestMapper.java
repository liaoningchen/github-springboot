package com.cdy.mybatis.dao;

import com.cdy.mybatis.dto.Test;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
* test
* @author chendeyou
* @date 2019/08/12
*/

public interface TestMapper {

    /**
    * [新增]
    * @author chendeyou
    * @date 2019/08/12
    **/
    int insert(@Param("test") Test test);

    /**
    * [刪除]
    * @author chendeyou
    * @date 2019/08/12
    **/
    int delete(@Param("id") int id);

    /**
    * [更新]
    * @author chendeyou
    * @date 2019/08/12
    **/
    int update(@Param("test") Test test);

    /**
    * [查詢] 根據主鍵 id 查詢
    * @author chendeyou
    * @date 2019/08/12
    **/
    Test selectByPrimaryKey(@Param("id") int id);

    /**
    * [查詢] 分頁查詢
    * @author chendeyou
    * @date 2019/08/12
    **/
    List<Test> pageList(@Param("offset") int offset,
                                                 @Param("pagesize") int pagesize);

    /**
    * [查詢] 分頁查詢 count
    * @author chendeyou
    * @date 2019/08/12
    **/
    int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}