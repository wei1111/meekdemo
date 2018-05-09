package njupt.mapper;

import java.util.List;

import njupt.domain.Student;
import njupt.domain.StudentExample;
import njupt.domain.StudentExample.Criteria;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMapperTest {
	ApplicationContext applicationContext = null;
	public StudentMapper studentMapper = null;

	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/beans.xml");
		studentMapper = (StudentMapper) applicationContext
				.getBean("studentMapper");
	}

	@Test
	public void testSelectByPrimaryKey() {
		Student student = studentMapper.selectByPrimaryKey(1);
		System.out.println(student);
	}

	@Test
	public void testSelectByExample() {

		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("陈维");
		List<Student> students = studentMapper.selectByExample(example);
		// System.out.println(students);
		for (Student s : students) {
			System.out.println(s);
		}
	}

	@Test
	public void testInsert() {
		Student student = new Student();
		student.setName("吴浩然");
		student.setPassword("131421");
		student.setstuId("B16010822");
		int i = studentMapper.insert(student);
		System.out.println("---------->>>>" + student.getId());
	}

	@Test
	public void testUpdateByExample() {
		Student student = new Student();
		student.setId(5);
		student.setName("吴浩然2");
		student.setPassword("131421");
		student.setstuId("B16010822");
		int i = studentMapper.updateByPrimaryKey(student);
		System.out.println("iii" + i);
		System.out.println("---------->>>>" + student.getId());
	}
}
