package com.cdy.mybatis.service.impl;

import com.cdy.mybatis.dao.TestMapper;
import com.cdy.mybatis.dto.ReturnT;
import com.cdy.mybatis.dto.Test;
import com.cdy.mybatis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* test
* @author chendeyou
* @date 2019/08/12
*/
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;


	@Override
	public int insert(Test test) {

		// valid
		if (test == null) {
			return ReturnT.FAIL_CODE;
        }

		testMapper.insert(test);
        return ReturnT.SUCCESS;
	}


	@Override
	public int delete(int id) {
		int ret = testMapper.delete(id);
		return ret>0?ReturnT.SUCCESS:ReturnT.FAIL;
	}


	@Override
	public int update(Test test) {
		int ret = testMapper.update(test);
		return ret>0?ReturnT.SUCCESS:ReturnT.FAIL;
	}


	@Override
	public Test selectByPrimaryKey(int id) {
		return testMapper.selectByPrimaryKey(id);
	}


	@Override
	public Map<String,Object> pageList(int offset, int pagesize) {

		List<Test> pageList = testMapper.pageList(offset, pagesize);
		int totalCount = testMapper.pageListCount(offset, pagesize);

		// result
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("pageList", pageList);
		result.put("totalCount", totalCount);

		return result;
	}

}
