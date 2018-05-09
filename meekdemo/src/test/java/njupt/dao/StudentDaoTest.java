package java.njupt.dao;

import njupt.dao.StudentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import njupt.domain.Student;

public class StudentDaoTest {

	@Test
	public void teststudentDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/beans.xml");
		StudentDao studentDao = (StudentDao) context.getBean("studentDaoImpl");
		// Student student1 = studentDao.getById(1);
		// System.out.println(student1);

		// Student student2 = new Student();
		// student2.setName("吴浩然5");
		// student2.setPassword("131421");
		// student2.setstuId("B16010822");
		// studentDao.insert(student2);
		// System.out.println("---------->>>>" + student2.getId());
		//
		// student2.setName("吴浩然4");
		// int i = studentDao.update(student2);
		// System.out.println("iii" + i);
		// System.out.println("---------->>>>" + student2.getId());

		// int i = studentDao.deleteByIds(new Integer[] { 3, 4 });
		// System.out.println("----------->" + i);

		Student student1 = studentDao.getById(1);
		System.out.println(student1);
		Student student2 = studentDao.getBystuId("B16020822");
		System.out.println(student2);
	}
}
