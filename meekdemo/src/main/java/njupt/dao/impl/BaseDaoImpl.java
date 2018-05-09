package njupt.dao.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import njupt.dao.BaseDao;
import njupt.utils.pagination.Page;

import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements
		BaseDao<T> {
	@Autowired
	// mybatis-spring 1.0无需此方法；mybatis-spring1.2必须注入。
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		System.out.println("注入时调用了setSqlSessionFactory");
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	private String ns; // 命名空间

	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

	public List<T> findPage(Page page) {
		List<T> oList = this.getSqlSession().selectList(ns + ".findPage", page);
		return oList;
	}

	public List<T> findAll() {
		List<T> oList = this.getSqlSession().selectList(ns + ".findAll");
		return oList;
	}

	public T getById(Serializable id) {
		return this.getSqlSession().selectOne(ns + ".selectByPrimaryKey", id);
	}
	
	public T getBystuId(String stuId) {
		return this.getSqlSession().selectOne(ns + ".selectBystuId", stuId);
	}

	public int insert(T entity) {
		return this.getSqlSession().insert(ns + ".insert", entity);
	}

	public int update(T entity) {
		return this.getSqlSession().update(ns + ".updateByPrimaryKey", entity);
	}

	public int deleteById(Serializable id) {
		return this.getSqlSession().delete(ns + ".deleteByPrimaryKey", id);
	}

	public int deleteBystuId(Serializable stuId) {
		return this.getSqlSession().delete(ns + ".deleteBystuId", stuId);
	}

	public int deleteByIds(Serializable[] ids) {
		return this.getSqlSession().delete(ns + ".deleteByPrimaryKeys", ids);
	}

}
