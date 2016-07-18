package com.vaizn.data.busi.service;

import com.vaizn.common.vo.SignInDataVo;
import com.vaizn.data.busi.dal.entity.SysUser;

public interface IUserService extends IBaseService<SysUser>{

	/**
	 * 检查登录用户有效性
	 * @param vo
	 * @return
	 */
	SysUser checkSignInUser(SignInDataVo vo) throws Exception;
}
