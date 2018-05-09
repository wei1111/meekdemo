package njupt.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import njupt.utils.pagination.Page;

public interface BaseDao<T> {
	public List<T> findPage(Page page); // 分页查询

	public List<T> findAll(); // 带条件查询，条件可以为null，既没有条件；返回list对象集合

	public T getById(Serializable id); // 只查询一个，常用于修改
	
	public T getBystuId(String stuId); // 只查询一个，常用于修改

	// 这里的返回值是操作的个数，不是主键，主键是自动插入插入的那个对象中的
	public int insert(T entity); // 插入，用实体作为参数

	public int update(T entity); // 修改，用实体作为参数

	public int deleteById(Serializable id); // 按id删除，删除一条；支持整数型和字符串类型ID

	public int deleteBystuId(Serializable stuId); // 按stuId删除，删除一条；支持整数型和字符串类型ID

	public int deleteByIds(Serializable[] ids); // 按id删除，删除一条；支持整数型和字符串类型ID
}
