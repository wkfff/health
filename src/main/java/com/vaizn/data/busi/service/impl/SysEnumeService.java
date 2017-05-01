package com.vaizn.data.busi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vaizn.common.vo.SysEnumeVo;
import com.vaizn.data.busi.dal.entity.SysEnume;
import com.vaizn.data.busi.dal.mapper.SysEnumeMapper;
import com.vaizn.data.busi.service.BaseService;
import com.vaizn.data.busi.service.ISysEnumeService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class SysEnumeService extends BaseService<SysEnume> implements ISysEnumeService {

	@Autowired
	private SysEnumeMapper sysEnumerMapper;
	
	@Override
	public Mapper<SysEnume> getMapper() {
		return this.sysEnumerMapper;
	}

	@Cacheable(value = "dictionaryEnume", key = "'sysEnumeList'")
	@Override
	public Map<String, List<SysEnumeVo>> getSysEnume() throws Exception {
		List<SysEnume> list = sysEnumerMapper.selectAll();
		Map<String, List<SysEnumeVo>> map = null;
		if (null != list && !list.isEmpty()) {
			List<SysEnumeVo> enumes = null;
			map = new HashMap<String, List<SysEnumeVo>>();
			SysEnumeVo enumeVo = null;
			for (SysEnume enume : list) {
				enumes = map.get(enume.getEnumeCode());
				if (null == enumes) {
					enumes = new ArrayList<SysEnumeVo>();
					map.put(enume.getEnumeCode(), enumes);
				}
				enumeVo = new SysEnumeVo(enume.getEnumeId(), enume.getEnumeValue(), enume.getEnumeText());
				enumes.add(enumeVo);
			}
		}
		return map;
	}

}
