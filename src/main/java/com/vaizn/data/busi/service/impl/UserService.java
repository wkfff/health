package com.vaizn.data.busi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaizn.common.vo.SignInDataVo;
import com.vaizn.data.busi.dal.entity.SysUser;
import com.vaizn.data.busi.dal.mapper.SysUserMapper;
import com.vaizn.data.busi.service.BaseService;
import com.vaizn.data.busi.service.IUserService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserService extends BaseService<SysUser> implements IUserService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	public Mapper<SysUser> getMapper() {
		return this.userMapper;
	}

	@Override
	public SysUser checkSignInUser(SignInDataVo vo) throws Exception{
		Example example = new Example(SysUser.class, false);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userAccount", vo.getUserAccount());
		criteria.andEqualTo("userPassword", vo.getUserPassword());
		criteria.andEqualTo("userStatus", "10");
		List<SysUser> list = userMapper.selectByExample(example);
		if (null != list && !list.isEmpty())
			return list.get(0);
		else
			return null;
	}

}
