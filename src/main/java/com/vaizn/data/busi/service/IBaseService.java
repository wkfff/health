package com.vaizn.data.busi.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface IBaseService<T> {

	/**
	 * 新增实体
	 * @param t
	 * @return
	 */
	public int insert(T t);
	
	/**
	 * 新增实体,不保存NULL值,使用数据库默认值
	 * @param t
	 * @return
	 */
	public int insertSelective(T t);
	
	/**
	 * 根据主键更新实体，NULL值会被更新
	 * @param t
	 * @return
	 */
	public int updateByPrimaryKey(T t);
	
	/**
	 * 根据主键更新实体，NULL值不会被更新
	 * @param t
	 * @return
	 */
	public int updateByPrimaryKeySelective(T t);
	
	/**
	 * 根据条件更新实体，NULL会被更新
	 * @param t
	 * @param example
	 * @return
	 */
	public int updateByExample(T t, Object example);
	
	/**
	 * 根据条件更新实体，NULL不会会被更新
	 * @param t
	 * @param example
	 * @return
	 */
	public int updateByExampleSelective(T t, Object example);
	
	/**
	 * 根据实体属性作为条件删除实体
	 * @param t
	 * @return
	 */
	public int delete(T t);
	
	/**
	 * 根据主键删除实体
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Object id);
	
	/**
	 * 根据查询条件删除实体
	 * @param example
	 * @return
	 */
	public int deleteByExample(Object example);
	
	/**
	 * 根据实体中的属性值进行查询，查询条件使用等号
	 * @param t
	 * @return
	 */
	public List<T> select(T t);
	
	/**
	 * 查询所有结果
	 * @return
	 */
	public List<T> selectAll();
	
	/**
	 * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * @param t
	 * @return
	 */
	public T selectOne(T t);
	
	/**
	 * 根据条件查询
	 * @param example
	 * @return
	 */
	public List<T> selectByExample(Object example);
	
	/**
	 * 根据example条件和RowBounds进行分页查询
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);
	
	/**
	 * 根据实体属性和RowBounds进行分页查询
	 * @param t
	 * @param rowBounds
	 * @return
	 */
	public List<T> selectByRowBounds(T t, RowBounds rowBounds);
	
	/**
	 * 根据主键字段进行查询
	 * @param id
	 * @return
	 */
	public T selectByPrimaryKey(Object id);
	
	/**
	 * 根据实体中的属性查询总数
	 * @param t
	 * @return
	 */
	public int selectCount(T t);
	
	/**
	 * 根据Example条件进行查询总数
	 * @param example
	 * @return
	 */
	public int selectCountByExample(Object example);
	
	/**
	 * 单表分页查询
	 * @param pageIndex 页码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public List<T> selectPage(T t, int pageIndex, int pageSize);
}
