package njupt.dao.impl;

import njupt.dao.StudentDao;
import njupt.domain.Student;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
	// 默认构造方法中设置 命名空间
	public StudentDaoImpl() {
		super.setNs("njupt.mapper.StudentMapper");
	}
	
}
