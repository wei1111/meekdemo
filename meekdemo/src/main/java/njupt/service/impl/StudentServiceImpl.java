package njupt.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import njupt.dao.StudentDao;
import njupt.domain.Student;
import njupt.service.StudentService;
import njupt.utils.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.itcast.service.StudentService#findPage(cn.itcast.pagination.Page)
	 */
	@Override
	public List<Student> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	// 带条件查询，条件参数封装到map
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Student getById(Serializable id) {
		return studentDao.getById(id);
	}

	@Override
	public Student getBystuId(String stuId) {
		return studentDao.getBystuId(stuId);
	}
	
	public void insert(Student entity) {
		// Student.setId(3); //程序生成，或者用oracle序列
		studentDao.insert(entity);
	}

	@Override
	public int update(Student entity) {
		return studentDao.update(entity);
	}

	@Override
	public int deleteById(Serializable id) {
		return studentDao.deleteById(id);

	}

	@Override
	public int deleteBystuId(Serializable stuId) {
		return studentDao.deleteBystuId(stuId);
	}

	@Override
	public int deleteByIds(Serializable[] ids) {
		return studentDao.deleteByIds(ids);
	}

}
