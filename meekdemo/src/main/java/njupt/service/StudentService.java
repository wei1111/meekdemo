package njupt.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import njupt.domain.Student;
import njupt.utils.pagination.Page;

public interface StudentService {
	public List<Student> findPage(Page page); // 分页查询

	public List<Student> findAll(); // 带条件查询，条件可以为null，既没有条件；返回list对象集合

	public Student getById(Serializable id); // 只查询一个，常用于修改

	public Student getBystuId(String stuId); // 只查询一个，常用于修改
	
	public void insert(Student entity); // 插入，用实体作为参数

	public int update(Student entity); // 修改，用实体作为参数

	public int deleteById(Serializable id); // 按id删除，删除一条；支持整数型和字符串类型ID,返回删除的个数

	public int deleteBystuId(Serializable stuId); // 按stuId删除，删除一条；支持整数型和字符串类型ID,返回删除的个数

	public int deleteByIds(Serializable[] ids); // 按id删除，删除一条；支持整数型和字符串类型ID，返回删除的个数
}
