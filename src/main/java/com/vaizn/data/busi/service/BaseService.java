package com.vaizn.data.busi.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.common.Mapper;

@Service
public abstract class BaseService<T> implements IBaseService<T> {
	
	public abstract Mapper<T> getMapper();
	
	/**
	 * 新增实体
	 * @param t
	 * @return
	 */
	@Override
	public int insert(T t) {
		return getMapper().insert(t);
	}
	
	/**
	 * 新增实体,不保存NULL值,使用数据库默认值
	 * @param t
	 * @return
	 */
	@Override
	public int insertSelective(T t) {
		return getMapper().insertSelective(t);
	}
	
	/**
	 * 根据主键更新实体，NULL值会被更新
	 * @param t
	 * @return
	 */
	@Override
	public int updateByPrimaryKey(T t) {
		return getMapper().updateByPrimaryKey(t);
	}
	
	/**
	 * 根据主键更新实体，NULL值不会被更新
	 * @param t
	 * @return
	 */
	@Override
	public int updateByPrimaryKeySelective(T t) {
		return getMapper().updateByPrimaryKeySelective(t);
	}
	
	/**
	 * 根据条件更新实体，NULL会被更新
	 * @param t
	 * @param example
	 * @return
	 */
	@Override
	public int updateByExample(T t, Object example) {
		return getMapper().updateByExample(t, example);
	}
	
	/**
	 * 根据条件更新实体，NULL不会会被更新
	 * @param t
	 * @param example
	 * @return
	 */
	@Override
	public int updateByExampleSelective(T t, Object example) {
		return getMapper().updateByExampleSelective(t, example);
	}
	
	/**
	 * 根据实体属性作为条件删除实体
	 * @param t
	 * @return
	 */
	@Override
	public int delete(T t) {
		return getMapper().delete(t);
	}
	
	/**
	 * 根据主键删除实体
	 * @param id
	 * @return
	 */
	@Override
	public int deleteByPrimaryKey(Object id) {
		return getMapper().deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据查询条件删除实体
	 * @param example
	 * @return
	 */
	@Override
	public int deleteByExample(Object example) {
		return getMapper().deleteByExample(example);
	}
	
	/**
	 * 根据实体中的属性值进行查询，查询条件使用等号
	 * @param t
	 * @return
	 */
	@Override
	public List<T> select(T t) {
		return getMapper().select(t);
	}
	
	/**
	 * 查询所有结果
	 * @return
	 */
	@Override
	public List<T> selectAll() {
		return getMapper().selectAll();
	}
	
	/**
	 * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * @param t
	 * @return
	 */
	@Override
	public T selectOne(T t) {
		return getMapper().selectOne(t);
	}
	
	/**
	 * 根据条件查询
	 * @param example
	 * @return
	 */
	@Override
	public List<T> selectByExample(Object example) {
		return getMapper().selectByExample(example);
	}
	
	/**
	 * 根据example条件和RowBounds进行分页查询
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		return getMapper().selectByExampleAndRowBounds(example, rowBounds);
	}
	
	/**
	 * 根据实体属性和RowBounds进行分页查询
	 * @param t
	 * @param rowBounds
	 * @return
	 */
	@Override
	public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
		return getMapper().selectByRowBounds(t, rowBounds);
	}
	
	/**
	 * 根据主键字段进行查询
	 * @param id
	 * @return
	 */
	@Override
	public T selectByPrimaryKey(Object id) {
		return getMapper().selectByPrimaryKey(id);
	}
	
	/**
	 * 根据实体中的属性查询总数
	 * @param t
	 * @return
	 */
	@Override
	public int selectCount(T t) {
		return getMapper().selectCount(t);
	}
	
	/**
	 * 根据Example条件进行查询总数
	 * @param example
	 * @return
	 */
	@Override
	public int selectCountByExample(Object example) {
		return getMapper().selectCountByExample(example);
	}
	
	/**
	 * 单表分页查询
	 * @param pageIndex 页码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@Override
	public List<T> selectPage(T t, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		return getMapper().select(t);
	}
}
