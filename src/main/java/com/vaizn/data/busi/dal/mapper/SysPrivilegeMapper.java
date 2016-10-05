package com.vaizn.data.busi.dal.mapper;

import java.util.List;

import com.vaizn.common.vo.UserPermissionVo;
import com.vaizn.data.busi.dal.entity.SysPrivilege;
import tk.mybatis.mapper.common.Mapper;

public interface SysPrivilegeMapper extends Mapper<SysPrivilege> {
	
	/**
	 * 根据用户标识获取所属权限
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<UserPermissionVo> getUserPrivilege(String userId) throws Exception;
}