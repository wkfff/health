package com.vaizn.data.busi.service;

import java.util.List;
import java.util.Map;

import com.vaizn.common.vo.SysEnumeVo;
import com.vaizn.data.busi.dal.entity.SysEnume;

public interface ISysEnumeService extends IBaseService<SysEnume> {

	/**
	 * 获取枚举字典，以字段名为key
	 * @return
	 */
	Map<String, List<SysEnumeVo>> getSysEnume() throws Exception;
}
